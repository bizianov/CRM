package feedback;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import project.controller.FeedbackController;
import project.service.FeedbackService;
import project.service.HotelService;
import project.service.TouristService;

import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Created by slava23 on 12/10/2016.
 */
public class FeedbackViewResolverTest {

    private MockMvc mockMvc;

    @Test
    public void findFeedbackById() throws Exception {
        mockMvc.perform(get("/getFeedbackById?id=0"))
                .andExpect(view().name("feedback/showFeedback"));
    }

    @Test
    public void findFeedbackByTourist() throws Exception {
        mockMvc.perform(get("/getFeedbackByTourist?id=0"))
                .andExpect(view().name("feedback/showAllFeedbacks"));
    }

    @Test
    public void findFeedbackByHotel() throws Exception {
        mockMvc.perform(get("/getFeedbackByHotel?id=0"))
                .andExpect(view().name("feedback/showAllFeedbacks"));
    }

    @Before
    public void setup(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views");
        viewResolver.setSuffix(".jsp");

        FeedbackService feedbackService = mock(FeedbackService.class);
        TouristService touristService = mock(TouristService.class);
        HotelService hotelService = mock(HotelService.class);
        FeedbackController feedbackController =
                FeedbackController.of(feedbackService,touristService,hotelService);
        mockMvc = MockMvcBuilders.standaloneSetup(feedbackController)
                .setViewResolvers(viewResolver)
                .build();
    }
}
