package passport;

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
import project.model.passport.Passport;
import project.model.tourist.Source;
import project.model.tourist.Tourist;
import project.security.SecurityConfig;
import project.service.PassportService;
import project.service.TouristService;

import java.text.ParseException;
import java.time.LocalDate;

import static org.junit.Assert.*;

/**
 * Created by slava23 on 11/29/2016.
 */

@RunWith(SpringRunner.class)
@DataJpaTest
@WebAppConfiguration
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration(classes = {AppWebConfig.class, AppRootConfig.class, SecurityConfig.class, Application.class})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class PassportServiceTest {

    @Autowired
    private PassportService passportService;
    @Autowired
    private TouristService touristService;
    private Passport passport;
    private Passport savedPassport;

    @Before
    public void setup(){
        Tourist tourist = Tourist.of("tFirstName","tLastName","tPhone","tEmail",
                LocalDate.of(1988,05,15), Source.CASUAL);
        Tourist savedTourist = touristService.saveTourist(tourist);
        passport = Passport.of("zzz","zzz",
                LocalDate.of(2012,10,10), LocalDate.of(2022,10,10), savedTourist);
        savedPassport = passportService.savePassport(passport);
    }

    @Test
    public void createPassport(){
        assertNotNull(savedPassport);
    }

    @Test
    public void findPassportById() throws ParseException {
        int id = savedPassport.getId();
        Passport passportById = passportService.getPassportById(id);
        assertEquals(passportById.getSerialNumber(),"zzz");
    }

    @Test
    public void updatePassport() throws ParseException {
        int id = savedPassport.getId();
        savedPassport.setSerialNumber("yyy");
        savedPassport.setIssuer("yyy");
        passportService.savePassport(savedPassport);
        Passport passportById = passportService.getPassportById(id);
        assertEquals(passportById.getSerialNumber(),"yyy");
        assertEquals(passportById.getIssuer(),"yyy");
    }

    @Test
    public void deletePassport() throws ParseException{
        int id = savedPassport.getId();
        passportService.deletePassport(id);
        Passport passportById = passportService.getPassportById(id);
        assertNull(passportById);
    }

}
