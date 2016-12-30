package project.search;

import lombok.Getter;
import org.springframework.stereotype.Component;
import project.model.tour.Tour;
import project.model.tourist.Tourist;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class TourSearchPredicates {
    @Getter
    private List<TourSearchPredicate> searchPredicates;

    @PostConstruct
    private void init() {
        searchPredicates = new ArrayList<>();
        
        searchPredicates.add(((tour, searchEntry) -> tour.getTouristList().stream()
                .map(Tourist::getId)
                .filter(id -> searchEntry.getTouristId() == null ||
                        searchEntry.getTouristId().equals(id))
                .findFirst()
                .isPresent()));
        searchPredicates.add(createStringMatchingPredicate(TourSearchEntry::getOperator, (t -> t.getTourOperator().name())));
        searchPredicates.add(createStringMatchingPredicate(TourSearchEntry::getHotelName, (t -> t.getHotel().getName())));
        searchPredicates.add(createStringMatchingPredicate(TourSearchEntry::getCountry, (t -> t.getHotel().getCountry())));
        searchPredicates.add(createStringMatchingPredicate(TourSearchEntry::getRegion, (t -> t.getHotel().getRegion())));
    }

    private TourSearchPredicate createStringMatchingPredicate(SearchKeySupplier<String> searchKeySupplier,
                                                              TourValueSupplier<String> tourValueSupplier) {
        return (tour, searchEntry) -> {
            String tourValue = tourValueSupplier.supply(tour);
            String searchKey = searchKeySupplier.supply(searchEntry);
            return searchEntry == null || tourValue.matches(searchKey);
        };
    }

    interface SearchKeySupplier<T> {
        T supply(TourSearchEntry searchEntry);
    }

    interface TourValueSupplier<T> {
        T supply(Tour tour);
    }
}
