package project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by slava23 on 10/11/2016.
 */

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"project/model"})
@ComponentScan(basePackages = {"project"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }
}
