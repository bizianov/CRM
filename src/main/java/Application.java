import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by slava23 on 10/11/2016.
 */

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"model"})
@ComponentScan(basePackages = {"model", "service", "controller"})
@EntityScan(basePackages = {"model"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }
}
