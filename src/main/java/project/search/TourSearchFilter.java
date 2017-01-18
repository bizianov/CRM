package project.search;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import project.model.tour.Tour;
import project.model.tourist.Tourist;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.apache.commons.lang3.StringUtils.isBlank;

@Component
@Slf4j
public class TourSearchFilter {
    private List<TourSearchPredicate> searchPredicates;

    @PostConstruct
    private void init() {
        searchPredicates = new ArrayList<>();

        searchPredicates.add(createTouristMatchingPredicate());
        searchPredicates.add(createStringMatchingPredicate(TourSearchEntry::getOperatorPattern, (t -> t.getTourOperator().name())));
        searchPredicates.add(createStringMatchingPredicate(TourSearchEntry::getHotelNamePattern, (t -> t.getHotel().getName())));
        searchPredicates.add(createStringMatchingPredicate(TourSearchEntry::getCountryPattern, (t -> t.getHotel().getCountry())));
        searchPredicates.add(createStringMatchingPredicate(TourSearchEntry::getRegionPattern, (t -> t.getHotel().getRegion())));
        searchPredicates.add(createDateIntervalPredicate(TourSearchEntry::getFromStartDate, TourSearchEntry::getToStartDate,
                Tour::getStartDate));
        searchPredicates.add(createDateIntervalPredicate(TourSearchEntry::getFromEndDate, TourSearchEntry::getToEndDate,
                Tour::getEndDate));
        searchPredicates.add(createDateIntervalPredicate(TourSearchEntry::getFromClosureDate, TourSearchEntry::getToClosureDate,
                Tour::getClosureDate));
    }

    public boolean checkTour(Tour tour, TourSearchEntry searchEntry) {
        return !searchPredicates.stream()
                .filter(p -> !p.apply(tour, searchEntry))
                .findFirst().isPresent();
    }

    private TourSearchPredicate createTouristMatchingPredicate() {
        return (tour, searchEntry) -> {
            List<Integer> ids = tour.getTouristList().stream()
                    .map(Tourist::getId)
                    .collect(toList());
            return searchEntry.getTouristId() == null || ids.contains(searchEntry.getTouristId());
        };
    }

    private TourSearchPredicate createStringMatchingPredicate(SearchKeySupplier<String> searchKeySupplier,
                                                              TourValueSupplier<String> tourValueSupplier) {
        return (tour, searchEntry) -> {
            String tourValue = tourValueSupplier.supply(tour);
            String searchKey = searchKeySupplier.supply(searchEntry);
            return isBlank(searchKey) || tourValue.matches(searchKey);
        };
    }

    private TourSearchPredicate createDateIntervalPredicate(SearchKeySupplier<String> fromKeySupplier,
                                                            SearchKeySupplier<String> toKeySupplier,
                                                            TourValueSupplier<LocalDate> tourValueSupplier) {
        return (tour, searchEntry) -> {
            String fromAsString = fromKeySupplier.supply(searchEntry);
            String toAsString = toKeySupplier.supply(searchEntry);
            if (isBlank(fromAsString) || isBlank(toAsString)) {
                return true;
            }

            LocalDate from = LocalDate.parse(fromAsString).minusDays(1);
            LocalDate to = LocalDate.parse(toAsString).plusDays(1);

            LocalDate targetDate = tourValueSupplier.supply(tour);

            return targetDate.isAfter(from) && targetDate.isBefore(to);
        };
    }

    interface SearchKeySupplier<T> {
        T supply(TourSearchEntry searchEntry);
    }

    interface TourValueSupplier<T> {
        T supply(Tour tour);
    }
}
