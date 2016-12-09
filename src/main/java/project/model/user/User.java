package project.model.user;

import lombok.*;

import javax.persistence.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by slava23 on 10/11/2016.
 */
@Entity
@Data
@ToString(exclude = {"id","password"})
@EqualsAndHashCode(exclude = {"id","password"})
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "of")
public class User {

    private static final String DEFAULT_PASSWORD = "123456";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull private String username;
    @NonNull private String password;
    @NonNull private boolean enabled;

    @ElementCollection(fetch = FetchType.EAGER)
    @Column(name = "role")
    @NonNull
    private Set<String> roles;

    public User(String username) {
        this(username, DEFAULT_PASSWORD, true,
                new HashSet<>(Arrays.asList(Roles.USER.getRole())));
    }
}
