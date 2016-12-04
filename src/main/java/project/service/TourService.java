package project.service;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.model.hotel.Hotel;
import project.model.tour.Tour;
import project.model.tour.TourDao;
import project.model.tour.TourOperator;
import project.model.tourist.Tourist;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by slava23 on 12/3/2016.
 */

@Service
public class TourService {

    @Autowired
    @Getter
    @Setter
    private TourDao tourDao;

    public Tour saveTour(Tour tour){
        return tourDao.save(tour);
    }

    public Tour findTourById(int id) {
        return tourDao.findOne(id);
    }

    public List<Tour> findAll() {
        return Lists.newArrayList(tourDao.findAll());
    }

    public List<Tour> findToursByTourist(Tourist tourist) {
        return Lists.newArrayList(tourDao.findAll())
                .stream()
                .filter(tour -> tour.getTouristList().contains(tourist))
                .collect(Collectors.toList());
    }

    public List<Tour> findToursByTourOperator(TourOperator tourOperator){
        return Lists.newArrayList(tourDao.findAll())
                .stream()
                .filter(tour -> tour.getTourOperator().equals(tourOperator))
                .collect(Collectors.toList());
    }

    public List<Tour> findToursByHotel (Hotel hotel){
        return Lists.newArrayList(tourDao.findAll())
                .stream()
                .filter(tour -> tour.getHotel().equals(hotel))
                .collect(Collectors.toList());
    }

    public List<Tour> findToursByCountry(String country){
        return Lists.newArrayList(tourDao.findAll())
                .stream()
                .filter(tour -> tour.getHotel().getCountry().equals(country))
                .collect(Collectors.toList());
    }

    public List<Tour> findToursByRegion(String region){
        return Lists.newArrayList(tourDao.findAll())
                .stream()
                .filter(tour -> tour.getHotel().getRegion().equals(region))
                .collect(Collectors.toList());
    }

    public List<Tour> findToursByYearMonth(int year, int month) {
        return Lists.newArrayList(tourDao.findAll())
                .stream()
                .filter(tour -> tour.getClosureDate().getMonthValue() == month
                        && tour.getClosureDate().getYear() == year)
                .collect(Collectors.toList());
    }

    public List<Tour> tourListDateProjection(List<Tour> tourList, LocalDate dateBefore, LocalDate dateAfter) {
        return tourList
                .stream()
                .filter(tour -> tour.getClosureDate().isAfter(dateAfter)
                        && tour.getClosureDate().isBefore(dateBefore))
                .collect(Collectors.toList());
    }

}
