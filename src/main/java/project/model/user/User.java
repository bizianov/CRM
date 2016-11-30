package project.model.user;

import com.google.common.base.MoreObjects;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
public class User {

    private static final String DEFAULT_PASSWORD = "123456";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    private boolean enabled;

    @ElementCollection(fetch = FetchType.EAGER)
    @Column(name = "role")
    private Set<String> roles;

    public User(String username) {
        this(username, DEFAULT_PASSWORD, true,
                new HashSet<>(Arrays.asList(Roles.USER.getRole())));
    }

    public User(String username, String password, boolean enabled, Set<String> roles) {
        this.username = username;
        this.password = password;
        this.enabled = enabled;
        this.roles = roles;
    }
}
