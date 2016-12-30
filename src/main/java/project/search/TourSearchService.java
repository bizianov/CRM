package project.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.model.tour.Tour;
import project.service.TourService;

import java.util.List;

@Service
public class TourSearchService {

    @Autowired
    private TourService tourService;

    public List<Tour> findTours(TourSearchEntry searchEntry) {
        List<Tour> allTours = tourService.findAll();



        return allTours;
    }
}
