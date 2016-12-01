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
import project.model.tourist.Source;
import project.model.tourist.Tourist;
import project.security.SecurityConfig;

import java.time.LocalDate;

import static org.junit.Assert.assertNotNull;

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
    public void createTourist() {
        Tourist tourist = new Tourist("x","y","050","1@1", LocalDate.of(1988,05,16), Source.CASUAL);
        Tourist savedTourist = entityManager.persist(tourist);
        assertNotNull(savedTourist);
    }
}
