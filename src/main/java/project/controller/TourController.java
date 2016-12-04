package project.controller;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.model.hotel.Hotel;
import project.model.tour.Tour;
import project.model.tour.TourOperator;
import project.model.tourist.Tourist;
import project.service.HotelService;
import project.service.TourService;
import project.service.TouristService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by slava23 on 12/3/2016.
 */

@Controller
@Data
@RequiredArgsConstructor(staticName = "of")
public class TourController {

    @Autowired
    @NonNull private TourService tourService;
    @Autowired
    @NonNull private HotelService hotelService;
    @Autowired
    @NonNull private TouristService touristService;

    @RequestMapping("/createTour")
    public String createTour(Model model,
                             @RequestParam(name = "startDate") String startDate,
                             @RequestParam(name = "endDate") String endDate,
                             @RequestParam(name = "tourOperator") String tourOperator,
                             @RequestParam(name = "isAvia") String isAvia,
                             @RequestParam(name = "visaRequired") String visaRequired,
                             @RequestParam(name = "priceBrutto") double priceBrutto,
                             @RequestParam(name = "hotelId") int hotelId,
                             @RequestParam(name = "closureDate") String closureDate,
                             @RequestParam(name = "touristId") List<String> touristIds){
        Hotel hotelById = hotelService.findHotelById(hotelId);
        if (hotelById == null){
            model.addAttribute("hotelId",hotelById);
            return "tour/error/invalidHotelId";
        }
        List<Tourist> touristList = new ArrayList<>();
        List<Integer> notFound = new ArrayList<>();
        touristIds
                .stream()
                .forEach(s -> {
                    if (s != null && !s.isEmpty()){
                        Tourist touristById = touristService.findTouristById(Integer.parseInt(s));
                        if (touristById != null){
                            touristList.add(touristById);
                        } else {
                            notFound.add(Integer.parseInt(s));
                        }
                    }
                });
        if (!notFound.isEmpty()){
            model.addAttribute("notFound", notFound);
            return "tour/error/invalidTouristId";
        }
        Tour tour = Tour.of(LocalDate.parse(startDate),LocalDate.parse(endDate),
                touristList,hotelById, TourOperator.valueOf(tourOperator),
                Boolean.getBoolean(isAvia), Boolean.getBoolean(visaRequired),
                priceBrutto,LocalDate.parse(closureDate));
        Tour savedTour = tourService.saveTour(tour);
        model.addAttribute("tour",savedTour);
        return "tour/showTour";
    }

    @RequestMapping("/getTourById")
    public String TourById(@RequestParam(name = "id") int id,
                           Model model){
        Tour tourById = tourService.findTourById(id);
        model.addAttribute("tour",tourById);
        return "tour/showTour";
    }

    @RequestMapping("/tour")
    public String passportMenu(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userLoggedIn = authentication.getName();
        model.addAttribute("userLoggedIn", userLoggedIn);
        return "tour/tour";
    }
}
