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

import java.time.DayOfWeek;
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

    public List<Tour> filterToursByTourist(Tourist tourist, List<Tour> invokingList) {
        return tourist != null ? invokingList
                .stream()
                .filter(tour -> tour.getTouristList().contains(tourist))
                .collect(Collectors.toList()) : Lists.newArrayList();
    }

    public List<Tour> filterToursByTourOperator(TourOperator tourOperator, List<Tour> invokingList){
        return invokingList
                .stream()
                .filter(tour -> tour.getTourOperator().equals(tourOperator))
                .collect(Collectors.toList());
    }

    public List<Tour> filterToursByHotel (Hotel hotel, List<Tour> invokingList){
        return hotel != null ? invokingList
                .stream()
                .filter(tour -> tour.getHotel().equals(hotel))
                .collect(Collectors.toList()) : Lists.newArrayList();
    }

    public List<Tour> filterToursByCountry(String country, List<Tour> invokingList){
        return country != null ? invokingList
                .stream()
                .filter(tour -> tour.getHotel().getCountry().equals(country))
                .collect(Collectors.toList()) : Lists.newArrayList();
    }

    public List<Tour> filterToursByRegion(String region, List<Tour> invokingList){
        return region != null ? invokingList
                .stream()
                .filter(tour -> tour.getHotel().getRegion().equals(region))
                .collect(Collectors.toList()) : Lists.newArrayList();
    }

    public List<Tour> filterToursByYearMonth(int year, int month) {
        return Lists.newArrayList(tourDao.findAll())
                .stream()
                .filter(tour -> tour.getClosureDate().getMonthValue() == month
                        && tour.getClosureDate().getYear() == year)
                .collect(Collectors.toList());
    }

    public List<Tour> filterToursByStartDate(LocalDate dateAfter, List<Tour> invokingList) {
        return invokingList
                .stream()
                .filter(tour -> tour.getStartDate().isAfter(dateAfter))
                .collect(Collectors.toList());
    }

    public List<Tour> filterToursByEndDate(LocalDate dateBefore, List<Tour> invokingList) {
        return invokingList
                .stream()
                .filter(tour -> tour.getStartDate().isBefore(dateBefore))
                .collect(Collectors.toList());
    }

    public List<Tour> filterToursByClosureDate(LocalDate start, LocalDate end, List<Tour> invokingList) {
        return invokingList
                .stream()
                .filter(tour -> tour.getClosureDate().isAfter(start) && tour.getClosureDate().isBefore(end))
                .collect(Collectors.toList());
    }

    public List<Tour> findToursSoldToday(){
        return Lists.newArrayList(tourDao.findAll())
                .stream()
                .filter(tour -> tour.getClosureDate().isEqual(LocalDate.now()))
                .collect(Collectors.toList());
    }

    public List<Tour> findToursSoldCurrentWeek(){
        return Lists.newArrayList(tourDao.findAll())
                .stream()
                .filter(tour ->
                        tour.getClosureDate().isAfter((LocalDate.now().with(DayOfWeek.MONDAY)).minusDays(1))
                && tour.getClosureDate().isBefore((LocalDate.now().with(DayOfWeek.SUNDAY)).plusDays(1)))
                .collect(Collectors.toList());
    }

    public Tour deleteTour(int id){
        Tour tourById = findTourById(id);
        if (tourById == null){
            return null;
        } else {
            tourDao.delete(tourById);
            return tourById;
        }
    }

}
