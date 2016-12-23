package project.controller;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import project.model.passport.Passport;
import project.model.tour.Tour;
import project.model.tourist.Tourist;
import project.service.PassportService;
import project.service.TourService;
import project.service.TouristService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by slava23 on 12/13/2016.
 */

@Controller
@Data
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of", onConstructor = @__(@Autowired))
public class NotificationController {

    @NonNull
    private TourService tourService;
    @NonNull
    private PassportService passportService;
    @NonNull
    private TouristService touristService;

    @RequestMapping(value = "/notifications")
    public String notificationMenu(Model model){
        model.addAttribute("oneDayToFlightTours",oneDayToFlightTours());
        model.addAttribute("threeDaysToFlightTours",threeDaysToFlightTours());
        model.addAttribute("returnToday", returnToday());
        model.addAttribute("feedbackPending", feedbackPending());
        model.addAttribute("birthdayToday", birthdayToday());
        model.addAttribute("passportsDueToExpire",passportsDueToExpire());
        return "notification/allNotifications";
    }

    private List<Tour> oneDayToFlightTours(){
        return tourService.findAll()
                .stream()
                .filter(tour -> tour.getStartDate().isEqual(LocalDate.now().plusDays(1)))
                .collect(Collectors.toList());
    }

    private List<Tour> threeDaysToFlightTours(){
        return tourService.findAll()
                .stream()
                .filter(tour -> tour.getStartDate().equals(LocalDate.now().plusDays(3)))
                .collect(Collectors.toList());
    }

    private List<Tour> returnToday(){
        return tourService.findAll()
                .stream()
                .filter(tour -> tour.getEndDate().equals(LocalDate.now()))
                .collect(Collectors.toList());
    }

    private List<Tour> feedbackPending(){
        return tourService.findAll()
                .stream()
                .filter(tour -> tour.getEndDate().equals(LocalDate.now().minusDays(2)))
                .collect(Collectors.toList());
    }

    private List<Tourist> birthdayToday(){
        return touristService.findTouristsByBirthday();
    }

    private List<Passport> passportsDueToExpire(){
        return passportService.getPassportsDueToExpire();
    }
}
