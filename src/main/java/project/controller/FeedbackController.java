package project.controller;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.model.feedback.Feedback;
import project.model.hotel.Hotel;
import project.model.tour.Tour;
import project.model.tourist.Tourist;
import project.service.FeedbackService;
import project.service.HotelService;
import project.service.TourService;
import project.service.TouristService;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by slava23 on 12/9/2016.
 */

@Controller
@Data
@RequiredArgsConstructor(staticName = "of", onConstructor = @__(@Autowired))
@NoArgsConstructor
public class FeedbackController {

    @NonNull
    private FeedbackService feedbackService;
    @NonNull
    private TouristService touristService;
    @NonNull
    private HotelService hotelService;
    @NonNull
    private TourService tourService;

    @RequestMapping("/getFeedbackById")
    public String findFeedbackById(@RequestParam(name = "id") int id,
                                  Model model){
        Feedback feedbackById = feedbackService.findFeedbackById(id);
        model.addAttribute("feedback", feedbackById);
        return "feedback/showFeedback";
    }

    @RequestMapping("/getFeedbackByTourist")
    public String findFeedbackByTourist(@RequestParam(name = "id") int id,
                                        Model model){
        Tourist touristById = touristService.findTouristById(id);
        List<Feedback> feedbackByTourist = feedbackService.findFeedbackByTourist(touristById);
        model.addAttribute("allFeedbacks", feedbackByTourist);
        return "feedback/showAllFeedbacks";
    }

    @RequestMapping("/getFeedbackByHotel")
    public String findFeedbackByHotel(@RequestParam(name = "id") int id,
                                      Model model){
        Hotel hotelById = hotelService.findHotelById(id);
        List<Feedback> feedbackByHotel = feedbackService.findFeedbackByHotel(hotelById);
        model.addAttribute("allFeedbacks", feedbackByHotel);
        return "feedback/showAllFeedbacks";
    }

    @RequestMapping("/createFeedback")
    public String createFeedback(@RequestParam(name = "tourId") int id,
                                 @RequestParam(name = "message") String message,
                                 Model model){
        Tour tourById = tourService.findTourById(id);
        if (tourById == null){
            model.addAttribute("tourId", id);
            return "feedback/error/invalidTourId";
        }
        Feedback savedFeedback = feedbackService.saveFeedback(Feedback.of(tourById,message, LocalDate.now()));
        model.addAttribute("feedback", savedFeedback);
        return "feedback/showFeedback";
    }

    @RequestMapping(value = "/feedback", method = GET)
    public String feedbackMenu(@RequestParam(name = "tourId", required = false) Integer tourId,
                               Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userLoggedIn = authentication.getName();
        model.addAttribute("tourId",tourId);
        model.addAttribute("userLoggedIn", userLoggedIn);
        return "feedback/feedback";
    }
}
