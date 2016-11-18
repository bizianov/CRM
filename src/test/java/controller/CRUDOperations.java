package controller;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import project.controller.UserController;
import project.service.UserService;

import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * Created by slava23 on 11/18/2016.
 */
public class CRUDOperations {

    @Test
    public void getUserById() throws Exception {
        UserService mockUserService = mock(UserService.class);
        UserController userController = new UserController(mockUserService);
        MockMvc mockMvc = standaloneSetup(userController).build();
        mockMvc.perform(get("/getUserById?id=1")).andExpect(view().name("showUser"));
    }

    @Test
    public void getUserByName() throws Exception {
        UserService mockUserService = mock(UserService.class);
        UserController userController = new UserController(mockUserService);
        MockMvc mockMvc = standaloneSetup(userController).build();
        mockMvc.perform(get("/getUserByName?username=slava")).andExpect(view().name("showUser"));
    }

    @Test
    public void createUser() throws Exception {
        UserService mockUserService = mock(UserService.class);
        UserController userController = new UserController(mockUserService);
        MockMvc mockMvc = standaloneSetup(userController).build();
        mockMvc.perform(get("/createUser?id=2&name=anfisa")).andExpect(view().name("showUser"));
    }
}
