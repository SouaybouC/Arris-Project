package fr.Aaris.configureTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
public class ConfigureTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConfigureTestApplication.class, args);
    }

}
