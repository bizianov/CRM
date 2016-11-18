package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.model.User;
import project.model.UserDao;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by slava23 on 10/11/2016.
 */

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User getUserById(int id){
        return userDao.findOne(id);
    }

    public User getUserByName(String name){
        Iterator<User> iterator = userDao.findAll().iterator();
        while (iterator.hasNext()){
            User next = iterator.next();
            if (next.getUsername().equals(name)){
                return next;
            }
        }
        return null;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
