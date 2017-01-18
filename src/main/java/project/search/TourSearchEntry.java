package project.search;

import lombok.Data;

@Data
public class TourSearchEntry {
    private Integer touristId;
    private String operatorPattern;
    private String hotelNamePattern;
    private String countryPattern;
    private String regionPattern;
    private String fromStartDate;
    private String toStartDate;
    private String fromEndDate;
    private String toEndDate;
    private String fromClosureDate;
    private String toClosureDate;
}
