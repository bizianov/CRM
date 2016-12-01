package tourist;

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

import java.text.ParseException;
import java.util.Arrays;

import static org.apache.commons.lang3.time.DateUtils.parseDate;
import static org.junit.Assert.assertNotNull;
import static project.model.passport.Passport.DATE_PATTERN;

/**
 * Created by slava23 on 12/1/2016.
 */

@RunWith(SpringRunner.class)
@DataJpaTest
@WebAppConfiguration
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration(classes = {AppWebConfig.class, AppRootConfig.class, SecurityConfig.class, Application.class})
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class TouristHibernateTest {

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void createTourist() throws ParseException {
        Passport passport = Passport.of("zzz","zzz",
                parseDate("2009-10-01",DATE_PATTERN), parseDate("2019-10-01",DATE_PATTERN));
        Tourist tourist = new Tourist("x","y","050","1@1",parseDate("1988-01-01",DATE_PATTERN), Arrays.asList(passport), Source.CASUAL);
        Tourist savedTourist = entityManager.persist(tourist);
        assertNotNull(savedTourist);
    }
}
