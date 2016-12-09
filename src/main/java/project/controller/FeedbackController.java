package project.controller;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.model.feedback.Feedback;
import project.service.FeedbackService;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by slava23 on 12/9/2016.
 */

@Controller
@Data
@RequiredArgsConstructor(staticName = "of")
public class FeedbackController {

    @NonNull
    private FeedbackService feedbackService;

    @RequestMapping("/getFeedbackById")
    public String getFeedbackById(@RequestParam(name = "id") int id,
                                  Model model){
        Feedback feedbackById = feedbackService.findFeedbackById(id);
        model.addAttribute("feedback", feedbackById);
        return "feedback/showFeedback";
    }

    @RequestMapping(value = "/feedback", method = GET)
    public String feedbackMenu(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userLoggedIn = authentication.getName();
        model.addAttribute("userLoggedIn", userLoggedIn);
        return "feedback/feedback";
    }
}
