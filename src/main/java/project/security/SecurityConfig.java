package project.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

/**
 * Created by slava23 on 10/19/2016.
 */

@Configuration
@EnableWebSecurity
@ComponentScan(basePackages = "project")
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
          .jdbcAuthentication()
             .dataSource(dataSource)
                .usersByUsernameQuery("select username, password, enabled from User where username = ?")
                .authoritiesByUsernameQuery("select username, role from UserRoles where username = ?");
    }
}
