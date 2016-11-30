package project.model.hotel;

import com.google.common.base.MoreObjects;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by slava23 on 11/28/2016.
 */

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
@ToString(exclude = "id")
@EqualsAndHashCode(exclude = "id")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull private String name;
    @NonNull private int rate;
    @NonNull private String country;
    @NonNull private String region;

}
