package project.model.passport;

import lombok.*;
import project.config.LocalDateAttributeConverter;
import project.model.tourist.Tourist;

import javax.persistence.*;
import java.time.LocalDate;

/**
 * Created by slava23 on 11/29/2016.
 */

@Entity
@Data
@ToString(exclude = {"id","tourist"})
@EqualsAndHashCode(exclude = "id")
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
public class Passport {

    public static final int EXPIRE_PERIOD = 12;
    public static final String DATE_PATTERN = "yyyy-MM-dd";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull private String serialNumber;
    @NonNull private String issuer;
    @Convert(converter = LocalDateAttributeConverter.class)
    @NonNull private LocalDate expireDate;
    @Convert(converter = LocalDateAttributeConverter.class)
    @NonNull private LocalDate issueDate;
    @ManyToOne
    private Tourist tourist;

    public boolean isDueToExpire(){
        return LocalDate.now().plusMonths(12).isAfter(expireDate);
    }
}
