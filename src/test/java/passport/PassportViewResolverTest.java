package passport;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import project.controller.PassportController;
import project.service.PassportService;
import project.service.TouristService;

import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Created by slava23 on 11/29/2016.
 */
public class PassportViewResolverTest {

    private MockMvc mockMvc;

    @Test
    public void getPassportById() throws Exception {
        mockMvc.perform(get("/getPassportById?id=1"))
                .andExpect(view().name("passport/showPassport"));
    }

    @Test
    public void createPassport() throws Exception {
        mockMvc.perform(get("/createPassport?serialNumber=AA0897OM&issuer=2012&issueDate=2012-10-12&expireDate=2022-10-12&tourist_id=-1"))
                .andExpect(view().name("passport/error/invalidTouristId"));
    }

    @Test
    public void deletePassport() throws Exception {
        mockMvc.perform(get("/deletePassport?id=1"))
                .andExpect(view().name("passport/deletePassport"));
    }

    @Test
    public void updatePassport() throws Exception {
        mockMvc.perform(get("/updatePassport?id=0"))
                .andExpect(view().name("passport/updatePassport"));
    }

    @Before
    public void setup(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");

        PassportService passportService = mock(PassportService.class);
        TouristService touristService = mock(TouristService.class);
        PassportController passportController = new PassportController(passportService, touristService);
        mockMvc = MockMvcBuilders.standaloneSetup(passportController)
                .setViewResolvers(viewResolver)
                .build();
    }
}
