import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * Created by slava23 on 10/11/2016.
 */

@SpringBootApplication
public class Application {
    public static void main(String[] args) {

        SpringApplication springApplication = new SpringApplication();
        ApplicationContext context = springApplication.run(Application.class, args);

    }
}
