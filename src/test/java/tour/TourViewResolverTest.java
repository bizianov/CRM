package tour;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import project.controller.TourController;
import project.service.TourService;

import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Created by slava23 on 12/3/2016.
 */
public class TourViewResolverTest {

    private MockMvc mockMvc;

    @Test
    public void findTourById() throws Exception {
        mockMvc.perform(get("/getTourById?id=1"))
                .andExpect(view().name("tour/showTour"));
    }

    @Before
    public void setup(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");

        TourService tourService = mock(TourService.class);
        TourController tourController = TourController.of(tourService);
        mockMvc = MockMvcBuilders.standaloneSetup(tourController)
                .setViewResolvers(viewResolver)
                .build();
    }
}
