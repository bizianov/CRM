package project.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.model.tourist.Tourist;
import project.service.TouristService;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.apache.commons.lang3.time.DateUtils.parseDate;
import static project.model.passport.Passport.DATE_PATTERN;

/**
 * Created by slava23 on 12/1/2016.
 */

@Controller
public class TouristController {

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

    @RequestMapping("/getTouristByBirthday")
    public String findTouristByBirthday(@RequestParam(name = "birthday") String birthday,
                                         Model model){
        try {
            Date _birthday = parseDate(birthday,DATE_PATTERN);
            List<Tourist> touristsByBirthday = touristService.findTouristsByBirthday(_birthday);
            model.addAttribute("allTourists", touristsByBirthday);
            return "tourist/showAllTourists";
        } catch (ParseException e) {
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
