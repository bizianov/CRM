package project.controller;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.model.user.User;
import project.service.UserService;

import java.util.HashSet;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by slava23 on 10/17/2016.
 */

@Controller
@Secured("ROLE_ADMIN")
@Data
@Slf4j
@RequiredArgsConstructor(staticName = "of", onConstructor = @__(@Autowired))
@NoArgsConstructor
public class UserController {

    @NonNull
    private UserService userService;
    @NonNull
    private BCryptPasswordEncoder passwordEncoder;

    @RequestMapping(value = "/getUserById", method = GET)
    public String getUserById(@RequestParam(value = "id") int id,
                              Model model){
        log.info("User with id={} was requested", id);
        User userById = userService.getUserById(id);
        model.addAttribute("user", userById);
        return "user/showUser";
    }

    @RequestMapping(value = "/getUserByName", method = GET)
    public String getUserByName(@RequestParam(value = "username") String name,
                                Model model){
        log.info("User with name={} was requested", name);
        User userByName = userService.getUserByName(name);
        model.addAttribute("user", userByName);
        return "user/showUser";
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
        return "user/showUser";
    }

    @RequestMapping(value = "/deleteUser", method = GET)
    @Transactional
    public String deleteUser(@RequestParam(value = "id") int id,
                             Model model){
        User deleteUser = userService.deleteUser(id);
        model.addAttribute("user", deleteUser);
        return "user/deleteUser";
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
            if (name != null && !name.isEmpty()) {
                userById.setUsername(name);
            }
            if (enabled != null && !enabled.isEmpty()) {
                log.info("enabled was set to {}", enabled);
                userById.setEnabled(Boolean.parseBoolean(enabled));
            }
            if (password != null && !password.isEmpty()) {
                userById.setPassword(passwordEncoder.encode(password));
            }
            userService.saveUser(userById);
        }
        model.addAttribute("user", userById);
        return "user/updateUser";
    }

    @RequestMapping(value = "/getAllUsers", method = GET)
    public String getAllUsers(Model model){
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("allUsers", allUsers);
        return "user/showAllUsers";
    }

    @RequestMapping(value = "/user", method = GET)
    public String userMenu(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userLoggedIn = authentication.getName();
        model.addAttribute("userLoggedIn", userLoggedIn);
        return "user/user";
    }
}
