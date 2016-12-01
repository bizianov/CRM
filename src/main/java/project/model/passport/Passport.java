package project.model.passport;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import org.apache.commons.lang3.time.DateUtils;
import project.model.tourist.Tourist;

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
    @NonNull private Date issueDate;
    @NonNull private Date expireDate;
    @ManyToOne
    private Tourist tourist;

    public boolean isDueToExpire(){
        return DateUtils.addMonths(new Date(), EXPIRE_PERIOD).after(this.getExpireDate());
    }
}
