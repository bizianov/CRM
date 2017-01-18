package project.search;

import project.model.tour.Tour;

public interface TourSearchPredicate {
    boolean apply(Tour tour, TourSearchEntry searchEntry);
}
