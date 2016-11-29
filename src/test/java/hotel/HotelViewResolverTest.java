package hotel;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import project.controller.HotelController;
import project.service.HotelService;

import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Created by slava23 on 11/28/2016.
 */
public class HotelViewResolverTest {

    private MockMvc mockMvc;

    @Test
    public void createHotel() throws Exception {
        mockMvc.perform(get("/createHotel?name=hotel1&rate=FIVE&country=Egypt&region=Hurgada"))
                .andExpect(view().name("hotel/showHotel"));
    }

    @Test
    public void getHotelById() throws Exception {
        mockMvc.perform(get("/getHotelById?id=1"))
                .andExpect(view().name("hotel/showHotel"));
    }

    @Test
    public void getHotelByName() throws Exception {
        mockMvc.perform(get("/getHotelByName?name=hotel1"))
                .andExpect(view().name("hotel/showHotel"));
    }

    @Test
    public void getHotelsByCountry() throws Exception {
        mockMvc.perform(get("/getHotelsByCountry?country=Egypt"))
                .andExpect(view().name("hotel/showAllHotels"))
                .andExpect(model().attributeExists("allHotels"));
    }

    @Test
    public void getHotelsByRegion() throws Exception {
        mockMvc.perform(get("/getHotelsByRegion?region=Hurgada"))
                .andExpect(view().name("hotel/showAllHotels"))
                .andExpect(model().attributeExists("allHotels"));
    }

    @Test
    public void deleteHotel() throws Exception {
        mockMvc.perform(get("/deleteHotel?id=0"))
                .andExpect(view().name("hotel/deleteHotel"));
    }

    @Test
    public void updateHotel() throws Exception {
        mockMvc.perform(get("/updateHotel?id=0"))
                .andExpect(view().name("hotel/updateHotel"));
    }

    @Before
    public void setup(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");

        HotelService hotelService = mock(HotelService.class);
        HotelController hotelController = new HotelController(hotelService);
        mockMvc = MockMvcBuilders.standaloneSetup(hotelController)
                .setViewResolvers(viewResolver)
                .build();
    }
}
