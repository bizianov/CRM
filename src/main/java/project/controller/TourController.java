package project.controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.model.tour.Tour;
import project.service.TourService;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by slava23 on 12/3/2016.
 */

@Controller
@Data
public class TourController {

    @Autowired
    private TourService tourService;

    @RequestMapping("/getTourById")
    public String TourById(@RequestParam(name = "id") int id,
                           Model model){
        Tour tourById = tourService.findTourById(id);
        model.addAttribute("tour",tourById);
        return "tour/showTour";
    }

    @RequestMapping("/tour")
    public String passportMenu(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userLoggedIn = authentication.getName();
        model.addAttribute("userLoggedIn", userLoggedIn);
        return "tour/tour";
    }
}
