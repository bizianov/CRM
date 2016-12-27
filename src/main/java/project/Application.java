package project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

/**
 * Created by slava23 on 10/11/2016.
 */

@SpringBootApplication
@EnableGlobalMethodSecurity(securedEnabled = true)
@EnableJpaRepositories(basePackages = {"project/model"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
