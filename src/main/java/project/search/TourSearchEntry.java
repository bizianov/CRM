package project.search;

import lombok.Data;

@Data
public class TourSearchEntry {
    private Integer touristId;
    private String operator;
    private String hotelName;
    private String country;
    private String region;
    private String startDate;
    private String endDate;
}
