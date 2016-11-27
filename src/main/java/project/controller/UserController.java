package project.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.model.User;
import project.service.UserService;

import java.util.HashSet;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by slava23 on 10/17/2016.
 */

@Controller
public class UserController {

    private final static Logger logger = LoggerFactory.getLogger(UserController.class);

    private UserService userService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/getUserById", method = GET)
    public String getUserById(@RequestParam(value = "id") int id,
                              Model model){
        logger.info("User with id={} was requested", id);
        User userById = userService.getUserById(id);
        model.addAttribute("user", userById);
        return "showUser";
    }

    @RequestMapping(value = "/getUserByName", method = GET)
    public String getUserByName(@RequestParam(value = "username") String name,
                                Model model){
        logger.info("User with name={} was requested", name);
        User userByName = userService.getUserByName(name);
        model.addAttribute("user", userByName);
        return "showUser";
    }

    @RequestMapping(value = "/createUser", method = GET)
    @Transactional
    public String createUser(@RequestParam(value = "name") String name,
                             @RequestParam(value = "role", required = false) List<String> roles,
                             Model model){
        User user = userService.createUser(name);
        if (roles != null && !roles.isEmpty()) {
            if (roles.contains("manager")){
                roles.remove("manager");
                roles.add("ROLE_USER");
            }
            if (roles.contains("admin")){
                roles.remove("admin");
                roles.add("ROLE_ADMIN");
            }
            user.setRoles(new HashSet<>(roles));
        }
        model.addAttribute("user", user);
        return "showUser";
    }

    @RequestMapping(value = "/deleteUser", method = GET)
    @Transactional
    public String deleteUser(@RequestParam(value = "id") int id,
                             Model model){
        User deleteUser = userService.deleteUser(id);
        model.addAttribute("user", deleteUser);
        return "deleteUser";
    }

    @RequestMapping(value = "/updateUser", method = GET)
    @Transactional
    public String updateUser(@RequestParam(value = "id") int id,
                             @RequestParam(value = "username", required = false) String name,
                             @RequestParam(value = "enabled", required = false) String enabled,
                             @RequestParam(value = "password", required = false) String password,
                             Model model){
        User userById = userService.getUserById(id);
        if (userById != null) {
            if (name != null && name != "") {
                userById.setUsername(name);
            }
            if (enabled != null && enabled != "") {
                logger.info("enabled was set to {}", enabled);
                userById.setEnabled(Boolean.parseBoolean(enabled));
            }
            if (password != null && password != "") {
                userById.setPassword(passwordEncoder.encode(password));
            }
        }
        User updatedUser = userService.saveUser(userById);
        model.addAttribute("user", updatedUser);
        return "updateUser";
    }

    @RequestMapping(value = "/getAllUsers", method = GET)
    public String getAllUsers(Model model){
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allUsers", allUsers);
        return "showAllUsers";
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
