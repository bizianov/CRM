package project.model.tourist;

import com.google.common.base.MoreObjects;
import lombok.*;
import project.config.LocalDateAttributeConverter;
import project.model.passport.Passport;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

/**
 * Created by slava23 on 11/30/2016.
 */

@Entity
@Data
@ToString(exclude = {"id"})
@EqualsAndHashCode(exclude = {"id","passports"})
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
public class Tourist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull private String firstName;
    @NonNull private String lastName;
    @NonNull private String phone;
    @NonNull private String email;
    @Convert(converter = LocalDateAttributeConverter.class)
    @NonNull private LocalDate birthday;
    @OneToMany(targetEntity = Passport.class, mappedBy = "tourist")
    private Collection<Passport> passports;
    @Enumerated(EnumType.STRING)
    @NonNull private Source source;

}
