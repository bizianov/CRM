package user;

import org.junit.Test;
import org.springframework.ui.ExtendedModelMap;
import project.controller.UserController;
import project.service.UserService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

/**
 * Created by slava23 on 11/18/2016.
 */

public class UserControllerTest {

    @Test
    public void userController() {
        UserService mockUserService = mock(UserService.class);
        UserController userController = new UserController(mockUserService);
        String viewName = userController.getUserById(1, new ExtendedModelMap());
        assertEquals("user/showUser", viewName);
    }
}
