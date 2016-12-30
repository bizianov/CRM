package project.controller;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import project.model.hotel.Hotel;
import project.model.hotel.Rate;
import project.model.tour.Tour;
import project.model.tour.TourOperator;
import project.search.TourSearchEntry;
import project.model.tourist.Source;
import project.model.tourist.Tourist;
import project.service.HotelService;
import project.search.TourSearchService;
import project.service.TourService;
import project.service.TouristService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static project.model.tour.Tour.DAY0;

/**
 * Created by slava23 on 12/3/2016.
 */

@Controller
@Slf4j
public class TourController {

    @Autowired
    TourService tourService;
    @Autowired
    HotelService hotelService;
    @Autowired
    TouristService touristService;
    @Autowired
    TourSearchService tourSearchService;

    @RequestMapping(value = "/createTour", method = RequestMethod.POST)
    public String createTour(Model model,
                              @RequestParam(name = "startDate") String startDate,
                              @RequestParam(name = "endDate") String endDate,
                              @RequestParam(name = "tourOperator") String tourOperator,
                              @RequestParam(name = "isAvia") String isAvia,
                              @RequestParam(name = "visaRequired") String visaRequired,
                              @RequestParam(name = "priceBrutto") double priceBrutto,
                              @RequestParam(name = "hotelId") int hotelId,
                              @RequestParam(name = "closureDate") String closureDate,
                              @RequestParam(name = "touristId") List<String> touristIds) {
        Hotel hotelById = hotelService.findHotelById(hotelId);
        if (hotelById == null) {
            model.addAttribute("hotelId", hotelById);
            return "tour/error/invalidHotelId";
        }
        List<Tourist> touristList = new ArrayList<>();
        List<Integer> notFound = new ArrayList<>();
        touristIds
                .stream()
                .forEach(s -> {
                    if (s != null && !s.isEmpty()) {
                        Tourist touristById = touristService.findTouristById(Integer.parseInt(s));
                        if (touristById != null) {
                            touristList.add(touristById);
                        } else {
                            notFound.add(Integer.parseInt(s));
                        }
                    }
                });
        if (!notFound.isEmpty()) {
            model.addAttribute("notFound", notFound);
            return "tour/error/invalidTouristId";
        }
        Tour tour = Tour.of(LocalDate.parse(startDate), LocalDate.parse(endDate),
                touristList, hotelById, TourOperator.valueOf(tourOperator),
                Boolean.parseBoolean(isAvia), Boolean.parseBoolean(visaRequired),
                priceBrutto, LocalDate.parse(closureDate));
        Tour savedTour = tourService.saveTour(tour);
        model.addAttribute("tour", savedTour);
        return "tour/showTour";
    }

    @RequestMapping("/createTourWithParameters")
    public String createTourWithParameters(Model model,
                                           @RequestParam(name = "startDate") String startDate, @RequestParam(name = "endDate") String endDate, @RequestParam(name = "closureDate") String closureDate,
                                           @RequestParam(name = "tourOperator") String tourOperator, @RequestParam(name = "isAvia") String isAvia,
                                           @RequestParam(name = "visaRequired") String visaRequired, @RequestParam(name = "priceBrutto") double priceBrutto,
                                           @RequestParam(name = "hotelId", required = false) Integer hotelId,
                                           @RequestParam(name = "name", required = false) String name, @RequestParam(name = "rate", required = false) String rate,
                                           @RequestParam(name = "country", required = false) String country, @RequestParam(name = "region", required = false) String region,
                                           @RequestParam(name = "id_1", required = false) Integer id_1, @RequestParam(name = "firstName_1", required = false) String firstName_1, @RequestParam(name = "lastName_1", required = false) String lastName_1,
                                           @RequestParam(name = "phone_1", required = false) String phone_1, @RequestParam(name = "email_1", required = false) String email_1,
                                           @RequestParam(name = "birthday_1", required = false) String birthday_1, @RequestParam(name = "source_1", required = false) String source_1,
                                           @RequestParam(name = "id_2", required = false) Integer id_2, @RequestParam(name = "firstName_2", required = false) String firstName_2, @RequestParam(name = "lastName_2", required = false) String lastName_2,
                                           @RequestParam(name = "phone_2", required = false) String phone_2, @RequestParam(name = "email_2", required = false) String email_2,
                                           @RequestParam(name = "birthday_2", required = false) String birthday_2, @RequestParam(name = "source_2", required = false) String source_2,
                                           @RequestParam(name = "id_3", required = false) Integer id_3, @RequestParam(name = "firstName_3", required = false) String firstName_3, @RequestParam(name = "lastName_3", required = false) String lastName_3,
                                           @RequestParam(name = "phone_3", required = false) String phone_3, @RequestParam(name = "email_3", required = false) String email_3,
                                           @RequestParam(name = "birthday_3", required = false) String birthday_3, @RequestParam(name = "source_3", required = false) String source_3,
                                           @RequestParam(name = "id_4", required = false) Integer id_4, @RequestParam(name = "firstName_4", required = false) String firstName_4, @RequestParam(name = "lastName_4", required = false) String lastName_4,
                                           @RequestParam(name = "phone_4", required = false) String phone_4, @RequestParam(name = "email_4", required = false) String email_4,
                                           @RequestParam(name = "birthday_4", required = false) String birthday_4, @RequestParam(name = "source_4", required = false) String source_4
    ) {
        Hotel targetHotel = null;
        List<Tourist> targetTouristList = new ArrayList<>();
        List<Integer> touristIds = Arrays.asList(id_1, id_2, id_3, id_4);
        List<String> touristFirstNames = Arrays.asList(firstName_1, firstName_2, firstName_3, firstName_4);
        List<String> touristLastNames = Arrays.asList(lastName_1, lastName_2, lastName_3, lastName_4);
        List<String> touristPhones = Arrays.asList(phone_1, phone_2, phone_3, phone_4);
        List<String> touristEmails = Arrays.asList(email_1, email_2, email_3, email_4);
        List<String> touristBirthdays = Arrays.asList(birthday_1, birthday_2, birthday_3, birthday_4);
        List<String> touristSources = Arrays.asList(source_1, source_2, source_3, source_4);

        if (hotelId != null) {
            Hotel hotelById = hotelService.findHotelById(hotelId);
            if (hotelById == null) {
                model.addAttribute("hotelId", hotelId);
                return "tour/error/invalidHotelId";
            } else {
                targetHotel = hotelById;
            }
        } else {
            if (!name.isEmpty() && !rate.isEmpty() && !country.isEmpty() && !region.isEmpty()) {
                Hotel hotel = Hotel.of(name, Rate.valueOf(rate).getRate(), country, region);
                if (Lists.newArrayList(hotelService.getHotelDao().findAll()).contains(hotel)) {
                    targetHotel = hotelService.findHotelByName(hotel.getName());
                } else {
                    Hotel savedHotel = hotelService.saveHotel(hotel);
                    targetHotel = savedHotel;
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            Integer touristId = touristIds.get(i);
            if (touristId != null) {
                Tourist touristById = touristService.findTouristById(touristId);
                if (touristById != null) {
                    targetTouristList.add(touristById);
                } else {
                    model.addAttribute("touristId", touristId);
                    return "tour/error/invalidTouristId";
                }
            } else {
                if (!touristFirstNames.get(i).isEmpty() && !touristLastNames.get(i).isEmpty() && !touristPhones.get(i).isEmpty()
                        && !touristEmails.get(i).isEmpty() && !touristBirthdays.get(i).isEmpty() && touristBirthdays.get(i) != null && !touristSources.get(i).isEmpty()) {
                    Tourist tourist = Tourist.of(touristFirstNames.get(i), touristLastNames.get(i), touristPhones.get(i),
                            touristEmails.get(i), LocalDate.parse(touristBirthdays.get(i)), Source.valueOf(touristSources.get(i)));
                    if (Lists.newArrayList(touristService.getTouristDao().findAll()).contains(tourist)) {
                        targetTouristList.add(tourist);
                    } else {
                        Tourist savedTourist = touristService.saveTourist(tourist);
                        targetTouristList.add(savedTourist);
                    }
                }
            }
        }

        if (targetHotel != null && !targetTouristList.isEmpty()) {
            Tour targetTour = Tour.of(LocalDate.parse(startDate), LocalDate.parse(endDate), targetTouristList, targetHotel,
                    TourOperator.valueOf(tourOperator), Boolean.parseBoolean(isAvia), Boolean.parseBoolean(visaRequired),
                    priceBrutto, LocalDate.parse(closureDate));
            tourService.saveTour(targetTour);
            model.addAttribute("tour", targetTour);
        } else {
            return "tour/error/noTourFound";
        }

        return "tour/showTour";
    }

    @RequestMapping("/updateTour")
    public String updateTour(Model model,
                             @RequestParam(name = "id") int id,
                             @RequestParam(name = "startDate", required = false) String startDate,
                             @RequestParam(name = "endDate", required = false) String endDate,
                             @RequestParam(name = "tourOperator", required = false) String tourOperator,
                             @RequestParam(name = "isAvia", required = false) String isAvia,
                             @RequestParam(name = "visaRequired", required = false) String visaRequired,
                             @RequestParam(name = "priceBrutto", required = false) Double priceBrutto,
                             @RequestParam(name = "hotelId", required = false) Integer hotelId,
                             @RequestParam(name = "closureDate", required = false) String closureDate,
                             @RequestParam(name = "touristId", required = false) List<String> touristIds) {
        Tour tourById = tourService.findTourById(id);
        if (tourById != null) {
            if (startDate != null && !startDate.isEmpty()) {
                tourById.setStartDate(LocalDate.parse(startDate));
            }
            if (endDate != null && !endDate.isEmpty()) {
                tourById.setEndDate(LocalDate.parse(endDate));
            }
            if (tourOperator != null && !tourOperator.isEmpty()) {
                tourById.setTourOperator(TourOperator.valueOf(tourOperator));
            }
            if (isAvia != null && !isAvia.isEmpty()) {
                tourById.setAvia(Boolean.parseBoolean(isAvia));
            }
            if (visaRequired != null && !visaRequired.isEmpty()) {
                tourById.setVisaRequired(Boolean.parseBoolean(visaRequired));
            }
            if (priceBrutto != null && !(priceBrutto.doubleValue() == 0)) {
                tourById.setPriceBrutto(priceBrutto);
            }
            if (hotelId != null && !(hotelId == 0)) {
                Hotel hotelById = hotelService.findHotelById(hotelId);
                if (hotelById == null) {
                    model.addAttribute("hotelId", hotelId);
                    return "tour/error/invalidHotelId";
                } else {
                    tourById.setHotel(hotelById);
                }
            }
            if (closureDate != null && !closureDate.isEmpty()) {
                tourById.setClosureDate(LocalDate.parse(closureDate));
            }
            if (touristIds != null && !touristIds.isEmpty()) {
                List<Tourist> newTouristList = new ArrayList<>();
                List<Integer> notFound = new ArrayList<>();
                touristIds
                        .stream()
                        .forEach(s -> {
                            if (s != null && !s.isEmpty()) {
                                Tourist touristById = touristService.findTouristById(Integer.parseInt(s));
                                if (touristById != null) {
                                    newTouristList.add(touristById);
                                } else {
                                    notFound.add(Integer.parseInt(s));
                                }
                            }
                        });
                if (!notFound.isEmpty()) {
                    model.addAttribute("notFound", notFound);
                    return "tour/error/invalidTouristId";
                }
                if (!newTouristList.isEmpty()) {
                    tourById.setTouristList(newTouristList);
                }
            }
            tourService.saveTour(tourById);
            model.addAttribute("tour", tourById);
            return "tour/showTour";
        } else {
            model.addAttribute("tourId", id);
            return "tour/error/invalidTourId";
        }
    }

    @RequestMapping("/getTourById")
    public String findTourById(@RequestParam(name = "id") int id,
                               Model model) {
        Tour tourById = tourService.findTourById(id);
        model.addAttribute("tour", tourById);
        return "tour/showTour";
    }

    @RequestMapping(path = "/findTours", method = RequestMethod.GET)
    public String findTours(Model model, TourSearchEntry tourSearchEntry) {
        log.info("Searching tours with params {}", tourSearchEntry);
        model.addAttribute("allTours", tourSearchService.findTours(tourSearchEntry));
        return "tour/showAllTours";
    }

    @RequestMapping(value = "/getToursByParameters", method = RequestMethod.GET)
    public String findToursByParameters(@RequestParam(name = "touristId", required = false) Integer touristId,
                                        @RequestParam(name = "byTourist", required = false) String byTourist,
                                        @RequestParam(name = "tourOperator", required = false) String tourOperator,
                                        @RequestParam(name = "byTourOperator", required = false) String byTourOperator,
                                        @RequestParam(name = "hotelId", required = false) Integer hotelId,
                                        @RequestParam(name = "byHotel", required = false) String byHotel,
                                        @RequestParam(name = "country", required = false) String country,
                                        @RequestParam(name = "byCountry", required = false) String byCountry,
                                        @RequestParam(name = "region", required = false) String region,
                                        @RequestParam(name = "byRegion", required = false) String byRegion,
                                        @RequestParam(name = "startDate", required = false) String startDate,
                                        @RequestParam(name = "byStartDate", required = false) String byStartDate,
                                        @RequestParam(name = "endDate", required = false) String endDate,
                                        @RequestParam(name = "byEndDate", required = false) String byEndDate,
                                        @RequestParam(name = "closureDateStart", required = false) String closureDateStart,
                                        @RequestParam(name = "closureDateEnd", required = false) String closureDateEnd,
                                        @RequestParam(name = "byClosureDate", required = false) String byClosureDate,
                                        Model model) {
        Boolean filtered = false;
        List<Tour> resultList = new ArrayList<>();
        List<Tour> invokingList = new ArrayList<>();

        if (byTourist != null) {
            if (touristId != null) {
                invokingList = filtered == false ? tourService.findAll() : resultList;
                Tourist touristById = touristService.findTouristById(touristId);
                resultList = tourService.filterToursByTourist(touristById, invokingList);
                filtered = true;
            }
        }

        if (byTourOperator != null) {
            if (tourOperator != null && !tourOperator.isEmpty()) {
                invokingList = filtered == false ? tourService.findAll() : resultList;
                resultList = tourService.filterToursByTourOperator(TourOperator.valueOf(tourOperator), invokingList);
                filtered = true;
            }
        }

        if (byHotel != null) {
            if (hotelId != null) {
                invokingList = filtered == false ? tourService.findAll() : resultList;
                Hotel hotelById = hotelService.findHotelById(hotelId);
                resultList = tourService.filterToursByHotel(hotelById, invokingList);
                filtered = true;
            }
        }

        if (byCountry != null) {
            if (country != null && !country.isEmpty()) {
                invokingList = filtered == false ? tourService.findAll() : resultList;
                resultList = tourService.filterToursByCountry(country, invokingList);
                filtered = true;
            }
        }

        if (byRegion != null) {
            if (region != null && !region.isEmpty()) {
                invokingList = filtered == false ? tourService.findAll() : resultList;
                resultList = tourService.filterToursByRegion(region, invokingList);
                filtered = true;
            }
        }

        if (byStartDate != null) {
            if (startDate != null && !startDate.isEmpty()) {
                invokingList = filtered == false ? tourService.findAll() : resultList;
                resultList = tourService.filterToursByStartDate(LocalDate.parse(startDate), invokingList);
                filtered = true;
            }
        }

        if (byEndDate != null) {
            if (endDate != null && !endDate.isEmpty()) {
                invokingList = filtered == false ? tourService.findAll() : resultList;
                resultList = tourService.filterToursByEndDate(LocalDate.parse(endDate), invokingList);
                filtered = true;
            }
        }

        if (byClosureDate != null) {
            LocalDate start = closureDateStart == null || closureDateStart.isEmpty() ? DAY0 : LocalDate.parse(closureDateStart);
            LocalDate end = closureDateEnd == null || closureDateEnd.isEmpty() ? LocalDate.now() : LocalDate.parse(closureDateEnd);
            invokingList = filtered == false ? tourService.findAll() : resultList;
            resultList = tourService.filterToursByClosureDate(start, end, invokingList);
            filtered = true;
        }

        model.addAttribute("allTours", resultList);
        return "tour/showAllTours";
    }

    @RequestMapping("/getAllToursCurrentMonth")
    public String findAllTours(Model model) {
        List<Tour> resultList = tourService.filterToursByYearMonth(
                LocalDate.now().getYear(), LocalDate.now().getMonthValue());
        model.addAttribute("allTours", resultList);
        return "tour/showAllTours";
    }


    @RequestMapping("/deleteTour")
    public String deleteTour(@RequestParam(name = "id") int id,
                             Model model) {
        Tour deleteTour = tourService.deleteTour(id);
        model.addAttribute("tour", deleteTour);
        return "tour/deleteTour";
    }

    @RequestMapping("/tour")
    public String tourMenu(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userLoggedIn = authentication.getName();
        model.addAttribute("userLoggedIn", userLoggedIn);
        return "tour/tour";
    }

    @RequestMapping("/findMenu")
    public String findTourMenu(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userLoggedIn = authentication.getName();
        model.addAttribute("userLoggedIn", userLoggedIn);
        return "tour/menu/findMenu";
    }

    @RequestMapping("/newFindMenu")
    public String newFindTourMenu(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userLoggedIn = authentication.getName();
        model.addAttribute("userLoggedIn", userLoggedIn);
        model.addAttribute("tourSearch", new TourSearchEntry());
        return "tour/menu/newFindMenu";
    }

    @RequestMapping("/createMenu")
    public String createTourMenu(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userLoggedIn = authentication.getName();
        model.addAttribute("userLoggedIn", userLoggedIn);
        return "tour/menu/createMenu";
    }
}
