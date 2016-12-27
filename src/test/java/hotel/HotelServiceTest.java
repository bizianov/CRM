package hotel;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import project.Application;
import project.config.AppRootConfig;
import project.config.AppWebConfig;
import project.model.hotel.Hotel;
import project.model.hotel.HotelDao;
import project.model.hotel.Rate;
import project.security.SecurityConfig;
import project.service.HotelService;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


/**
 * Created by slava23 on 11/28/2016.
 */

@RunWith(SpringRunner.class)
@DataJpaTest
@WebAppConfiguration
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration(classes = {AppWebConfig.class, AppRootConfig.class, SecurityConfig.class, Application.class})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class HotelServiceTest {

    @Autowired
    private HotelService hotelService;
    @Autowired
    private TestEntityManager testEntityManager;
    private Hotel hotel;
    private Hotel savedHotel;

    @Before
    public void setUp(){
        hotel = Hotel.of("hotelZ", Rate.FOUR.getRate(), "Germany", "Munich");
        savedHotel = testEntityManager.persist(hotel);
    }

    @After
    public void tearDown(){
        hotelService.deleteHotel(hotel.getId());
    }

    @Test
    public void findHotelById(){

        int id = savedHotel.getId();
        Hotel hotelById = hotelService.findHotelById(id);
        assertEquals(hotelById.getName(), "hotelZ");
    }

    @Test
    public void findHotelByName(){
        String hotelName = savedHotel.getName();
        Hotel hotelByName = hotelService.findHotelByName(hotelName);
        assertEquals(hotelByName.getName(),"hotelZ");
    }

    @Test
    public void deleteHotel(){
        int id = savedHotel.getId();
        hotelService.deleteHotel(id);
        Hotel hotelById = hotelService.findHotelById(id);
        assertNull(hotelById);
    }

    @Test
    public void updateHotel(){
        int id = savedHotel.getId();
        savedHotel.setRate(1);
        savedHotel.setRegion("Berlin");
        hotelService.saveHotel(savedHotel);
        Hotel hotelById = hotelService.findHotelById(id);
        assertEquals(hotelById.getRegion(),"Berlin");
        assertEquals(hotelById.getRate(), 1);
    }

}
