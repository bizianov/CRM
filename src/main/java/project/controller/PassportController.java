package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.model.passport.Passport;
import project.model.tourist.Tourist;
import project.service.PassportService;
import project.service.TouristService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static project.model.passport.Passport.DATE_PATTERN;

/**
 * Created by slava23 on 11/29/2016.
 */

@Controller
public class PassportController {

    private PassportService passportService;
    private TouristService touristService;

    @Autowired
    public PassportController(PassportService passportService, TouristService touristService) {
        this.passportService = passportService;
        this.touristService = touristService;
    }

    @RequestMapping(value = "/getPassportById", method = GET)
    public String getPassportById(@RequestParam(name = "id") int id,
                                  Model model){
        Passport passportById = passportService.getPassportById(id);
        model.addAttribute("passport", passportById);
        return "passport/showPassport";
    }

    @RequestMapping(value = "/getExpirePassports", method = GET)
    public String getPassportsDueToExpire(Model model){
        List<Passport> passportsDueToExpire = passportService.getPassportsDueToExpire();
        model.addAttribute("passportsDueToExpire", passportsDueToExpire);
        return "passport/expirePassports";
    }

    @RequestMapping(value = "/createPassport", method = GET)
    public String createPassport(@RequestParam(name = "serialNumber") String serialNumber,
                                 @RequestParam(name = "issuer")String issuer,
                                 @RequestParam(name = "issueDate")String issueDate,
                                 @RequestParam(name = "expireDate")String expireDate,
                                 @RequestParam(name = "tourist_id") int tourist_id,
                                 Model model){
        Tourist touristById = touristService.findTouristById(tourist_id);
        if (touristById != null) {
            try {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern(DATE_PATTERN);
                LocalDate _issueDate = LocalDate.parse(issueDate, dtf);
                LocalDate _expireDate = LocalDate.parse(expireDate, dtf);
                Passport passport = passportService.createPassport(serialNumber, issuer, _issueDate, _expireDate,touristById);
                model.addAttribute("passport", passport);
                return "passport/showPassport";
            } catch (DateTimeParseException e) {
                List<String> inputDates = new ArrayList<>();
                inputDates.add(issueDate);
                inputDates.add(expireDate);
                model.addAttribute("inputDates", inputDates);
                return "passport/error/invalidDate";
            }
        } else {
            model.addAttribute("tourist_id", tourist_id);
            return "passport/error/invalidTouristId";
        }
    }

    @RequestMapping(value = "/updatePassport", method = GET)
    public String updatePassport(@RequestParam(name = "id") int id,
                                 @RequestParam(name = "serialNumber", required = false) String serialNumber,
                                 @RequestParam(name = "issuer", required = false) String issuer,
                                 @RequestParam(name = "issueDate", required = false) String issueDate,
                                 @RequestParam(name = "expireDate", required = false) String expireDate,
                                 Model model){
        Passport passportById = passportService.getPassportById(id);
        if (passportById != null){
            if (serialNumber != null && !serialNumber.isEmpty()){
                passportById.setSerialNumber(serialNumber);
            }
            if (issuer != null && !issuer.isEmpty()){
                passportById.setIssuer(issuer);
            }
            try {
                if (issueDate != null && !issueDate.isEmpty()) {
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern(DATE_PATTERN);
                    LocalDate _issueDate = LocalDate.parse(issueDate, dtf);
                    passportById.setIssueDate(_issueDate);
                }
                if (expireDate != null && !expireDate.isEmpty()) {
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern(DATE_PATTERN);
                    LocalDate _expireDate = LocalDate.parse(expireDate, dtf);
                    passportById.setExpireDate(_expireDate);
                }
            }catch (DateTimeParseException e){
                List<String> inputDates = new ArrayList<>();
                inputDates.add(issueDate);
                inputDates.add(expireDate);
                model.addAttribute("inputDates", inputDates);
                return "passport/error/invalidDate";
            }
            passportService.savePassport(passportById);
        }
        model.addAttribute("passport", passportById);
        return "passport/updatePassport";
    }

    @RequestMapping(value = "/deletePassport", method = GET)
    public String deletePassport(@RequestParam(name = "id") int id,
                                 Model model){
        Passport passport = passportService.deletePassport(id);
        model.addAttribute("passport", passport);
        return "passport/deletePassport";
    }

    @RequestMapping(value = "/passport", method = GET)
    public String passportMenu(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userLoggedIn = authentication.getName();
        model.addAttribute("userLoggedIn", userLoggedIn);
        return "passport/passport";
    }

    public PassportService getPassportService() {
        return passportService;
    }

    public void setPassportService(PassportService passportService) {
        this.passportService = passportService;
    }

    public TouristService getTouristService() {
        return touristService;
    }

    public void setTouristService(TouristService touristService) {
        this.touristService = touristService;
    }
}
