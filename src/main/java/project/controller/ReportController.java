package project.controller;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import project.service.ReportService;

import java.io.IOException;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by slava23 on 12/16/2016.
 */

@Data
@RequiredArgsConstructor(staticName = "of", onConstructor = @__(@Autowired))
@Controller
public class ReportController {

    @NonNull
    private ReportService reportService;

    @RequestMapping(value = "/report", method = GET)
    public String reportMenu(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userLoggedIn = authentication.getName();
        model.addAttribute("userLoggedIn", userLoggedIn);
        return "report/report";
    }

    @RequestMapping("/generateMonthlyReport")
    public String generateMonthlyReport(Model model) throws IOException {
        reportService.generateMonthlyReport();
        return "report/reportReady";
    }

    @RequestMapping("/generateWeeklyReport")
    public String generateWeeklyReport(Model model) throws IOException {
        reportService.generateWeeklyReport();
        return "report/reportReady";
    }

    @RequestMapping("/generateDailyReport")
    public String generateDailyReport(Model model) throws IOException {
        reportService.generateDailyReport();
        return "report/reportReady";
    }
}
