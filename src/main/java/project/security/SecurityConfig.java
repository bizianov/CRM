package project.security;

import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

/**
 * Created by slava23 on 10/19/2016.
 */

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = {"project"})
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@NoArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String USERS_BY_USERNAME_QUERY =
            "SELECT username, password, enabled FROM user WHERE username = ?";
    private static final String AUTHORITIES_BY_USERNAME_QUERY =
            "SELECT username, role FROM user INNER JOIN user_roles ON id=user_id WHERE username = ?";

    @NonNull
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
          .jdbcAuthentication()
             .dataSource(dataSource)
                .passwordEncoder(passwordEncoder())
                .usersByUsernameQuery(USERS_BY_USERNAME_QUERY)
                .authoritiesByUsernameQuery(AUTHORITIES_BY_USERNAME_QUERY);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .permitAll()
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
    }



    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
