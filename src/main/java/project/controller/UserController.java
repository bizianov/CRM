package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import project.model.User;
import project.service.UserService;

import static org.springframework.web.bind.annotation.RequestMethod.*;

/**
 * Created by slava23 on 10/17/2016.
 */

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/getUserById", method = GET)
    public String getUserById(@RequestParam(value = "id") int id,
                              Model model){
        User userById = userService.getUserById(id);
        model.addAttribute("user", userById);
        return "showUser";
    }

    @RequestMapping(value = "/getUserByName", method = GET)
    public String getUserByName(@RequestParam(value = "username") String name,
                                Model model){
        User userByName = userService.getUserByName(name);
        model.addAttribute("user", userByName);
        return "showUser";
    }

    @RequestMapping(value = "/createUser", method = GET)
    public String createUser(@RequestParam(value = "id") int id,
                             @RequestParam(value = "name") String name,
                             Model model){
        User user = userService.createUser(id, name);
        model.addAttribute("user", user);
        return "showUser";
    }

    @RequestMapping(value = "/deleteUser", method = GET)
    public String deleteUser(@RequestParam(value = "id") int id,
                             Model model){
        User deleteUser = userService.deleteUser(id);
        model.addAttribute("user", deleteUser);
        return "deleteUser";
    }

    @RequestMapping(value = "/updateUser", method = GET)
    public String updateUser(@RequestParam(value = "id") int id,
                             @RequestParam(value = "username", required = false) String name,
                             @RequestParam(value = "enabled", required = false) Boolean enabled,
                             @RequestParam(value = "password", required = false) String password,
                             Model model){
        User userById = userService.getUserById(id);
        if (userById != null) {
            if (name != null) {
                userById.setUsername(name);
            }
            if (enabled != null) {
                userById.setEnabled(enabled);
            }
            if (password != null) {
                userById.setPassword(password);
            }
        }
        model.addAttribute("user", userById);
        userService.saveUser(userById);
        return "updateUser";
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
