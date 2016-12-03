package project.model.tour;

import lombok.*;
import project.config.LocalDateAttributeConverter;
import project.model.hotel.Hotel;
import project.model.tourist.Tourist;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by slava23 on 12/3/2016.
 */

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
@ToString(exclude = {"id","isAvia","visaRequired","priceNetto","profit"})
@EqualsAndHashCode(exclude = {"id","isAvia","visaRequired","priceNetto","profit"})
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Convert(converter = LocalDateAttributeConverter.class)
    @NonNull private LocalDate startDate;
    @Convert(converter = LocalDateAttributeConverter.class)
    @NonNull private LocalDate endDate;
    @ManyToMany
    @JoinTable(name = "tourist_tour",
            joinColumns = @JoinColumn(name = "tour_id"),
            inverseJoinColumns = @JoinColumn(name = "tourist_id"))
    @NonNull List<Tourist> touristList;
    @ManyToOne
    @NonNull private Hotel hotel;
    @Enumerated(EnumType.STRING)
    @NonNull private TourOperator tourOperator;

    private boolean isAvia;
    private boolean visaRequired;

    @NonNull private double priceBrutto;
    private double priceNetto;
    private double profit;
}
