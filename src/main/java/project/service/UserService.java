package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import project.model.user.User;
import project.model.user.UserDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by slava23 on 10/11/2016.
 */

@Service
public class UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private PasswordEncoder encoder;

    public User getUserById(int id){
        return userDao.findOne(id);
    }

    public User getUserByName(String name){
        return userDao.findByUsername(name);
    }

    public User createUser(String name){
        User user = new User(name);
        user.setPassword(encoder.encode(user.getPassword()));
        return userDao.save(user);
    }

    public User deleteUser(int id){
        User userById = getUserById(id);
        if (userById != null) {
            userDao.delete(userById);
        }
        return userById;
    }

    public User saveUser(User user){
        User savedUser = userDao.save(user);
        return savedUser;
    }

    public List<User> getAllUsers(){
        List<User> allUsers = new ArrayList<>();
        Iterable<User> all = userDao.findAll();
        all.forEach(user -> allUsers.add(user));
        return allUsers;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
