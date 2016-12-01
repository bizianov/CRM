package tourist;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import project.controller.TouristController;
import project.service.TouristService;

import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


/**
 * Created by slava23 on 12/1/2016.
 */
public class TouristViewResolverTest {

    private MockMvc mockMvc;

    @Test
    public void findTouristById() throws Exception {
        mockMvc.perform(get("/getTouristById?id=2"))
                .andExpect(view().name("tourist/showTourist"));
    }

    @Test
    public void findTouristByPhone() throws Exception {
        mockMvc.perform(get("/getTouristByPhone?phone=050"))
                .andExpect(view().name("tourist/showTourist"));
    }

    @Test
    public void findTouristByEmail() throws Exception {
        mockMvc.perform(get("/getTouristByEmail?email=1@ukr.net"))
                .andExpect(view().name("tourist/showTourist"));
    }

    @Test
    public void findTouristsByFirstName() throws Exception {
        mockMvc.perform(get("/getTouristByFirstName?firstName=slava"))
                .andExpect(view().name("tourist/showAllTourists"));
    }

    @Test
    public void findTouristsByLastName() throws Exception {
        mockMvc.perform(get("/getTouristByLastName?lastName=bizianov"))
                .andExpect(view().name("tourist/showAllTourists"));
    }

    @Test
    public void findTouristsByBirthday() throws Exception {
        mockMvc.perform(get("/getTouristsByBirthday"))
                .andExpect(view().name("tourist/showAllTourists"));
    }

    @Before
    public void setup(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");

        TouristService touristService = mock(TouristService.class);
        TouristController touristController = new TouristController(touristService);
        mockMvc = MockMvcBuilders.standaloneSetup(touristController)
                .setViewResolvers(viewResolver)
                .build();
    }
}
