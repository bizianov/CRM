package project.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.model.tour.Tour;
import project.service.TourService;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class TourSearchService {

    @Autowired
    private TourService tourService;
    @Autowired
    private TourSearchFilter tourSearchFilter;

    public List<Tour> findTours(TourSearchEntry searchEntry) {
        return tourService.findAll().stream()
                .filter(tour -> tourSearchFilter.checkTour(tour, searchEntry))
                .collect(toList());
    }
}
