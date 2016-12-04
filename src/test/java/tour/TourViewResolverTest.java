package tour;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import project.controller.TourController;
import project.service.HotelService;
import project.service.TourService;
import project.service.TouristService;

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

    @Test
    public void deleteTour() throws Exception {
        mockMvc.perform(get("/deleteTour?id=0"))
                .andExpect(view().name("tour/deleteTour"));
    }

    @Test
    public void createTourInvalidHotelId() throws Exception {
        mockMvc.perform(get("/createTour?startDate=2016-12-10&endDate=2016-12-20&tourOperator=TPG&isAvia=false&visaRequired=false&priceBrutto=1234&hotelId=-1&closureDate=2016-12-08&touristId=2&touristId=6"))
                .andExpect(view().name("tour/error/invalidHotelId"));
    }

    @Before
    public void setup(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");

        TourService tourService = mock(TourService.class);
        HotelService hotelService = mock(HotelService.class);
        TouristService touristService = mock(TouristService.class);
        TourController tourController = TourController.of(tourService,hotelService,touristService);
        mockMvc = MockMvcBuilders.standaloneSetup(tourController)
                .setViewResolvers(viewResolver)
                .build();
    }
}
