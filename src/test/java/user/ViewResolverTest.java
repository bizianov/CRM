package user;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import project.controller.UserController;
import project.service.UserService;

import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Created by slava23 on 11/18/2016.
 */
public class ViewResolverTest {

    private MockMvc mockMvc;

    @Test
    public void getUserById() throws Exception {
        mockMvc.perform(get("/getUserById?id=1")).andExpect(view().name("showUser"));
    }

    @Test
    public void getUserByName() throws Exception {
        mockMvc.perform(get("/getUserByName?username=slava")).andExpect(view().name("showUser"));
    }

    @Test
    public void createUser() throws Exception {
        mockMvc.perform(get("/createUser?name=anfisa")).andExpect(view().name("showUser"));
    }

    @Test
    public void deleteUser() throws Exception {
       mockMvc.perform(get("/deleteUser?id=2")).andExpect(view().name("deleteUser"));
    }

    @Test
    public void updateUser() throws Exception {
        mockMvc.perform(get("/updateUser?id=1&username=slava1")).andExpect(view().name("updateUser"));
    }

    @Before
    public void setup() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/view/");
        viewResolver.setSuffix(".jsp");

        UserService mockUserService = mock(UserService.class);
        UserController userController = new UserController(mockUserService);
        mockMvc = MockMvcBuilders.standaloneSetup(userController)
                .setViewResolvers(viewResolver)
                .build();
    }
}
