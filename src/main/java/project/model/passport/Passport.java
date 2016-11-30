package project.model.passport;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import lombok.*;
import project.model.tourist.Tourist;
import project.utils.date.DateUtils;

import javax.persistence.*;
import java.util.Date;

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
