package service;

import model.User;
import model.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by slava23 on 10/11/2016.
 */

@Service
@RestController
public class UserService {

    @Autowired
    private UserDao userDao;

    @RequestMapping("/getUser")
    public User getUserById(int id){
        return userDao.findOne(id);
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
