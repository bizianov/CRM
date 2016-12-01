package project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.model.tourist.Tourist;
import project.model.tourist.TouristDao;

import java.util.Date;
import java.util.List;

/**
 * Created by slava23 on 12/1/2016.
 */

@Service
public class TouristService {

    @Autowired
    private TouristDao touristDao;

    public Tourist findTouristById(int id){
        return touristDao.findOne(id);
    }

    public List<Tourist> findTouristsByFirstName(String firstName){
        return touristDao.findByFirstName(firstName);
    }

    public List<Tourist> findTouristsByLastName(String lastName){
        return touristDao.findByLastName(lastName);
    }

    public Tourist findTouristByPhone(String phone){
        return touristDao.findByPhone(phone);
    }

    public Tourist findTouristByEmail(String email){
        return touristDao.findByEmail(email);
    }

    public List<Tourist> findTouristsByBirthday(Date birthday){
        return touristDao.findByBirthday(birthday);
    }
}
