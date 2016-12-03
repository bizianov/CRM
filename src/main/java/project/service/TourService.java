package project.service;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.model.tour.Tour;
import project.model.tour.TourDao;

/**
 * Created by slava23 on 12/3/2016.
 */

@Service
public class TourService {

    @Autowired
    @Getter@Setter private TourDao tourDao;

    public Tour findTourById(int id){
        return tourDao.findOne(id);
    }

}
