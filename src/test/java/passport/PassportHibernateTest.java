package passport;

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
import project.security.SecurityConfig;
import project.service.PassportService;
import project.validator.DateValidator;

import java.text.ParseException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by slava23 on 11/29/2016.
 */

@RunWith(SpringRunner.class)
@DataJpaTest
@WebAppConfiguration
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration(classes = {AppWebConfig.class, AppRootConfig.class, SecurityConfig.class, Application.class})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class PassportHibernateTest {

    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private PassportService passportService;
    @Autowired
    private DateValidator dateValidator;

    @Test
    public void findPassportById() throws ParseException {
        Passport passport = Passport.of("xxx","xxx",
                dateValidator.validate("2012-01-01"), dateValidator.validate("2022-01-01"));
        Passport savedPassport = entityManager.persist(passport);
        int id = savedPassport.getId();
        Passport passportById = passportService.getPassportById(id);
        assertEquals(passportById.getSerialNumber(),"xxx");
    }

    @Test
    public void updatePassport() throws ParseException {
        Passport passport = Passport.of("xxx","xxx",
                dateValidator.validate("2012-01-01"), dateValidator.validate("2022-01-01"));
        Passport savedPassport = entityManager.persist(passport);
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
        Passport passport = Passport.of("xxx","xxx",
                dateValidator.validate("2012-01-01"), dateValidator.validate("2022-01-01"));
        Passport savedPassport = entityManager.persist(passport);
        int id = savedPassport.getId();
        passportService.deletePassport(id);
        Passport passportById = passportService.getPassportById(id);
        assertNull(passportById);
    }

}
