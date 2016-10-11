import controller.UserController;
import model.User;
import model.UserDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by slava23 on 10/11/2016.
 */

@SpringBootApplication
@ComponentScan({"model","controller"})
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class);

    }

    @Bean
    public CommandLineRunner demo(UserDao userDao){
        return (args) -> {
            User userById = new UserController().getUserById(1);
            System.out.println(userById);
        };
    }

}
