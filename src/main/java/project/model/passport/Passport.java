package project.model.passport;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import org.apache.commons.lang3.time.DateUtils;

/**
 * Created by slava23 on 11/29/2016.
 */

@Entity
@Data
@ToString(exclude = "id")
@EqualsAndHashCode(exclude = "id")
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
public class Passport {

    private static final int EXPIRE_PERIOD = 12;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull private String serialNumber;
    @NonNull private String issuer;
    @NonNull private Date issueDate;
    @NonNull private Date expireDate;

    public boolean isDueToExpire(){
        return DateUtils.addMonths(new Date(), EXPIRE_PERIOD).after(this.getExpireDate());
    }
}
