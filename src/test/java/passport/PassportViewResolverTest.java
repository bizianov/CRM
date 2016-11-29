package passport;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import project.controller.PassportController;
import project.service.PassportService;
import project.validator.DateValidator;
import project.validator.Validator;

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

    @Before
    public void setup(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");

        PassportService passportService = mock(PassportService.class);
        DateValidator dateValidator = mock(DateValidator.class);
        PassportController passportController = new PassportController(passportService, dateValidator);
        mockMvc = MockMvcBuilders.standaloneSetup(passportController)
                .setViewResolvers(viewResolver)
                .build();
    }
}
