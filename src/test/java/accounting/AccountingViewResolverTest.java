package accounting;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import project.controller.AccountingController;
import project.service.AccountingService;
import project.service.TourService;

import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Created by slava23 on 12/12/2016.
 */
public class AccountingViewResolverTest {

    private MockMvc mockMvc;

    @Test
    public void findAccountingById() throws Exception {
        mockMvc.perform(get("/getAccountingById?id=0"))
                .andExpect(view().name("accounting/showAccounting"));
    }

    @Test
    public void findAccountingByTour() throws Exception {
        mockMvc.perform(get("/getAccountingByTour?id=-1"))
                .andExpect(view().name("accounting/error/invalidTourId"));
    }

    @Test
    public void findAccountingByTourist() throws Exception {
        mockMvc.perform(get("/getAccountingByTourist?lastName=q"))
                .andExpect(view().name("accounting/showAllAccountings"));
    }

    @Test
    public void findOpenedAccountings() throws Exception {
        mockMvc.perform(get("/getOpenedAccountings"))
                .andExpect(view().name("accounting/showAllAccountings"));
    }

    @Test
    public void findAccountingsByDate() throws Exception {
        mockMvc.perform(get("/getAccountingsByDate?year=2016&month=11"))
                .andExpect(view().name("accounting/showAllAccountings"));
    }

    @Before
    public void setup(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views");
        viewResolver.setSuffix(".jsp");

        AccountingService accountingService = mock(AccountingService.class);
        TourService tourService = mock(TourService.class);
        AccountingController accountingController = AccountingController.of(accountingService,tourService);
        mockMvc = MockMvcBuilders.standaloneSetup(accountingController)
                .setViewResolvers(viewResolver)
                .build();
    }
}
