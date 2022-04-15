package dev.alexgrechishnikov.pp_3_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.persistence.EntityManagerFactory;

@SpringBootApplication
public class Pp31Application {

    public static void main(String[] args) {
        SpringApplication.run(Pp31Application.class, args);
    }

}
