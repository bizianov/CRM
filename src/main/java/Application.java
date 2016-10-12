import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import service.UserService;
import model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by slava23 on 10/11/2016.
 */

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"model"})
@ComponentScan(basePackages = {"model", "service"})
@EntityScan(basePackages = {"model"})
public class Application {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication();
        ApplicationContext context = springApplication.run(Application.class, args);
        UserService userController = context.getBean(UserService.class);
        User userById = userController.getUserById(1);
        System.out.println(userById);
    }
}
