package project.model.feedback;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import project.converter.LocalDateAttributeConverter;
import project.model.tour.Tour;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by slava23 on 12/9/2016.
 */

@Data
@Entity
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne
    @NonNull private Tour tour;
    @NonNull private String message;
    @Convert(converter = LocalDateAttributeConverter.class)
    private LocalDate date;
}
