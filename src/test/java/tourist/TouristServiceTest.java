package tourist;

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
import project.model.tourist.Source;
import project.model.tourist.Tourist;
import project.security.SecurityConfig;
import project.service.TouristService;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by slava23 on 12/1/2016.
 */

@RunWith(SpringRunner.class)
@DataJpaTest
@WebAppConfiguration
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration(classes = {AppWebConfig.class, AppRootConfig.class, SecurityConfig.class, Application.class})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class TouristServiceTest {

    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private TouristService touristService;
    private Tourist tourist, savedTourist;

    @Before
    public void setup(){
        tourist = Tourist.of("first name","last name","phone","test@test", LocalDate.of(1988,05,16), Source.CASUAL);
        savedTourist = entityManager.persist(tourist);
    }

    @Test
    public void createTourist(){
        assertNotNull(savedTourist);
        assertEquals(tourist,savedTourist);
    }

    @Test
    public void deleteTourist(){
        int id = savedTourist.getId();
        Tourist deleteTourist = touristService.deleteTourist(id);
        Tourist touristById = touristService.findTouristById(id);
        assertNotNull(deleteTourist);
        assertNull(touristById);
    }

    @Test
    public void findTouristById(){
        Tourist touristById = touristService.findTouristById(tourist.getId());
        assertEquals(savedTourist,touristById);
    }

    @Test
    public void findTouristByPhone(){
        Tourist touristByPhone = touristService.findTouristByPhone(savedTourist.getPhone());
        assertEquals(savedTourist,touristByPhone);
    }

    @Test
    public void findTouristByEmail(){
        Tourist touristByEmail = touristService.findTouristByEmail(savedTourist.getEmail());
        assertEquals(savedTourist,touristByEmail);
    }

    @Test
    public void findTouristsByFirstName(){
        List<Tourist> touristsByFirstName = touristService.findTouristsByFirstName(savedTourist.getFirstName());
        assertTrue(touristsByFirstName.contains(savedTourist));
    }

    @Test
    public void findTouristsByLastName(){
        List<Tourist> touristsByLastName = touristService.findTouristsByLastName(savedTourist.getLastName());
        assertTrue(touristsByLastName.contains(savedTourist));
    }

    @Test
    public void findTouristsByBirthday(){
        Tourist tourist = Tourist.of("bFirstName","bLastName","bPhone","bEmail",LocalDate.now(),Source.OTHER);
        Tourist savedTourist = entityManager.persist(tourist);
        List<Tourist> touristsByBirthday = touristService.findTouristsByBirthday();
        assertTrue(touristsByBirthday.contains(savedTourist));
    }
}
