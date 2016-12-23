package report;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import project.controller.ReportController;
import project.service.TourService;
import project.service.report.TourReportService;
import project.service.report.TouristReportService;

import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Created by slava23 on 12/23/2016.
 */
public class ReportViewResolverTest {

    private MockMvc mockMvc;

    @Test
    public void monthlyReport() throws Exception {
        mockMvc.perform(get("/generateMonthlyReport"))
                .andExpect(view().name("report/reportReady"));
    }

    @Test
    public void weeklyReport() throws Exception {
        mockMvc.perform(get("/generateWeeklyReport"))
                .andExpect(view().name("report/reportReady"));
    }

    @Test
    public void dailyReport() throws Exception {
        mockMvc.perform(get("/generateDailyReport"))
                .andExpect(view().name("report/reportReady"));
    }

    @Test
    public void customReport() throws Exception {
        mockMvc.perform(get("/generateCustomReport?startDate=2016-12-19&endDate=2017-02-15"))
                .andExpect(view().name("report/reportReady"));
    }

    @Test
    public void exportContacts() throws Exception {
        mockMvc.perform(get("/exportContacts"))
                .andExpect(view().name("report/reportReady"));
    }

    @Before
    public void setup(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views");
        viewResolver.setSuffix(".jsp");

        TourReportService tourReportService = mock(TourReportService.class);
        TouristReportService touristReportService = mock(TouristReportService.class);
        TourService tourService = mock(TourService.class);
        ReportController reportController = ReportController.of(tourReportService,touristReportService,tourService);
        mockMvc = MockMvcBuilders.standaloneSetup(reportController)
                .setViewResolvers(viewResolver)
                .build();
    }
}
