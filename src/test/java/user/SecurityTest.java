package user;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import project.Application;
import project.config.AppRootConfig;
import project.config.AppWebConfig;
import project.security.SecurityConfig;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.logout;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.unauthenticated;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;


/**
 * Created by slava23 on 11/24/2016.
 */

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {AppWebConfig.class, AppRootConfig.class, SecurityConfig.class, Application.class})
@WebAppConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
public class SecurityTest {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Before
    public void setup() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity()) //will perform all of the initial setup to integrate Spring Security with Spring MVC Test
                .build();
    }

    @Test
    public void auth() throws Exception {
        mvc
                .perform(formLogin().user("slava").password("1234"))
                .andExpect(authenticated());

    }

    @Test
    public void authFailed() throws Exception {
        mvc
                .perform(formLogin().user("slava").password("incorrect password"))
                .andExpect(unauthenticated());
    }

    @Test
    public void signout() throws Exception {
        mvc
                .perform(formLogin().user("slava").password("1234"))
                .andExpect(authenticated());
        mvc
                .perform(logout())
                .andExpect(unauthenticated());
    }
}
