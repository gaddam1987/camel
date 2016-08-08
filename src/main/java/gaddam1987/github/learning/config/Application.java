package gaddam1987.github.learning.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "gaddam1987.github.learning.test")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
