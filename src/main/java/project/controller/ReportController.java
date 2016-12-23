package project.controller;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.model.tour.Tour;
import project.service.report.TourReportService;
import project.service.TourService;
import project.service.report.TouristReportService;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by slava23 on 12/16/2016.
 */

@Controller
@Data
@RequiredArgsConstructor(staticName = "of", onConstructor = @__(@Autowired))
@NoArgsConstructor
public class ReportController {

    @NonNull
    private TourReportService tourReportService;
    @NonNull
    private TouristReportService touristReportService;
    @NonNull
    private TourService tourService;

    //@Secured("ROLE_ADMIN")
    @RequestMapping(value = "/report", method = GET)
    public String reportMenu(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userLoggedIn = authentication.getName();
        model.addAttribute("userLoggedIn", userLoggedIn);
        return "report/report";
    }

    @RequestMapping("/generateMonthlyReport")
    public String generateMonthlyReport(Model model) throws IOException {
        tourReportService.generateMonthlyReport();
        return "report/reportReady";
    }

    @RequestMapping("/generateWeeklyReport")
    public String generateWeeklyReport(Model model) throws IOException {
        tourReportService.generateWeeklyReport();
        return "report/reportReady";
    }

    @RequestMapping("/generateDailyReport")
    public String generateDailyReport(Model model) throws IOException {
        tourReportService.generateDailyReport();
        return "report/reportReady";
    }

    @RequestMapping("/generateCustomReport")
    public String generateCustomReport(@RequestParam(name = "startDate") String startDate,
                                       @RequestParam(name = "endDate") String endDate,
                                       Model model) throws IOException {
        List<Tour> tours = tourService.filterToursByClosureDate(LocalDate.parse(startDate),
                LocalDate.parse(endDate), tourService.findAll());
        tourReportService.generateCustomReport(tours);
        return "report/reportReady";
    }

    @RequestMapping("/exportContacts")
    public String exportContacts() throws IOException {
        touristReportService.exportContacts();
        return "report/reportReady";
    }
}
