package project.service;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.model.tourist.Tourist;
import project.model.tourist.TouristDao;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by slava23 on 12/1/2016.
 */

@Service
@Slf4j
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

    public List<Tourist> findTouristsByBirthday(){
        return Lists.newArrayList(touristDao.findAll())
                .stream()
                .filter(tourist ->
                        (LocalDate.now().getMonthValue() == tourist.getBirthday().getMonthValue()
                                && LocalDate.now().getDayOfMonth() == tourist.getBirthday().getDayOfMonth()))
                .collect(Collectors.toList());
    }

    public Tourist saveTourist(Tourist tourist){
        return touristDao.save(tourist);
    }

    public Tourist deleteTourist(int id){
        Tourist touristById = touristDao.findOne(id);
        if (touristById != null){
            touristDao.delete(touristById);
            return touristById;
        }
        return null;
    }
}
