package project.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.model.tourist.Source;
import project.model.tourist.Tourist;
import project.service.TouristService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static project.model.passport.Passport.DATE_PATTERN;

/**
 * Created by slava23 on 12/1/2016.
 */

@Controller
public class TouristController {

    private static final Logger logger = LoggerFactory.getLogger(TouristController.class);
    private TouristService touristService;

    public TouristController(TouristService touristService) {
        this.touristService = touristService;
    }

    @RequestMapping("/getTouristById")
    public String findTouristById(@RequestParam(name = "id") int id,
                                  Model model){
        Tourist touristById = touristService.findTouristById(id);
        model.addAttribute("tourist", touristById);
        return "tourist/showTourist";
    }

    @RequestMapping("/getTouristByPhone")
    public String findTouristByPhone(@RequestParam(name = "phone") String phone,
                                  Model model){
        Tourist touristByPhone = touristService.findTouristByPhone(phone);
        model.addAttribute("tourist", touristByPhone);
        return "tourist/showTourist";
    }

    @RequestMapping("/getTouristByEmail")
    public String findTouristByEmail(@RequestParam(name = "email") String email,
                                     Model model){
        Tourist touristByEmail = touristService.findTouristByEmail(email);
        model.addAttribute("tourist", touristByEmail);
        return "tourist/showTourist";
    }

    @RequestMapping("/getTouristByFirstName")
    public String findTouristByFirstName(@RequestParam(name = "firstName") String firstName,
                                         Model model){
        List<Tourist> touristsByFirstName = touristService.findTouristsByFirstName(firstName);
        model.addAttribute("allTourists", touristsByFirstName);
        return "tourist/showAllTourists";
    }

    @RequestMapping("/getTouristByLastName")
    public String findTouristByLastName(@RequestParam(name = "lastName") String lastName,
                                         Model model){
        List<Tourist> touristsByLastName = touristService.findTouristsByLastName(lastName);
        model.addAttribute("allTourists", touristsByLastName);
        return "tourist/showAllTourists";
    }

    @RequestMapping("/createTourist")
    public String createTourist(@RequestParam(name = "firstName") String firstName,
                                @RequestParam(name = "lastName") String lastName,
                                @RequestParam(name = "phone") String phone,
                                @RequestParam(name = "email") String email,
                                @RequestParam(name = "birthday") String birthday,
                                @RequestParam(name = "source") String source,
                                Model model){
        try {
            Tourist tourist = Tourist.of(firstName, lastName, phone, email, LocalDate.parse(birthday, DateTimeFormatter.ofPattern(DATE_PATTERN)), Source.valueOf(source));
            Tourist savedTourist = touristService.saveTourist(tourist);
            model.addAttribute("tourist", savedTourist);
            return "tourist/showTourist";
        } catch (DateTimeParseException e) {
            model.addAttribute("birthday", birthday);
            return "tourist/error/invalidBirthday";
        }
    }

    @RequestMapping(value = "/tourist", method = GET)
    public String touristMenu(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userLoggedIn = authentication.getName();
        model.addAttribute("userLoggedIn", userLoggedIn);
        return "tourist/tourist";
    }

    public TouristService getTouristService() {
        return touristService;
    }

    public void setTouristService(TouristService touristService) {
        this.touristService = touristService;
    }
}
