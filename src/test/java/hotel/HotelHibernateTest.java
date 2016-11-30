package hotel;

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
public class HotelHibernateTest {

    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private HotelService hotelService;

    @Test
    public void findHotelById(){
        Hotel hotel = Hotel.of("hotel0", Rate.FOUR.getRate(), "Germany", "Munich");
        Hotel savedHotel = entityManager.persist(hotel);
        int id = savedHotel.getId();
        Hotel hotelById = hotelService.findHotelById(id);
        assertEquals(hotelById.getName(), "hotel0");
    }

    @Test
    public void findHotelByName(){
        Hotel hotel = Hotel.of("hotel0", Rate.FOUR.getRate(), "Germany", "Munich");
        Hotel savedHotel = entityManager.persist(hotel);
        String hotelName = savedHotel.getName();
        Hotel hotelByName = hotelService.findHotelByName(hotelName);
        assertEquals(hotelByName.getName(),"hotel0");
    }

    @Test
    public void deleteHotel(){
        Hotel hotel = Hotel.of("hotel0", Rate.FOUR.getRate(), "Germany", "Munich");
        Hotel savedHotel = entityManager.persist(hotel);
        int id = savedHotel.getId();
        hotelService.deleteHotel(id);
        Hotel hotelById = hotelService.findHotelById(id);
        assertNull(hotelById);
    }

    @Test
    public void updateHotel(){
        Hotel hotel = Hotel.of("hotel0", Rate.FOUR.getRate(), "Germany", "Munich");
        Hotel savedHotel = entityManager.persist(hotel);
        int id = savedHotel.getId();
        savedHotel.setRate(1);
        savedHotel.setRegion("Berlin");
        hotelService.saveHotel(savedHotel);
        Hotel hotelById = hotelService.findHotelById(id);
        assertEquals(hotelById.getRegion(),"Berlin");
        assertEquals(hotelById.getRate(), 1);
    }

}
