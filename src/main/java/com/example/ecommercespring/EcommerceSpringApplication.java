package com.example.ecommercespring;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing
public class EcommerceSpringApplication {

    public static void main(String[] args) {

        Dotenv dotenv = Dotenv.configure().load(); // load the environment variable from .env file
        dotenv.entries().forEach(entry ->System.setProperty(entry.getKey(), entry.getValue())); // set system properties from environment variable
        SpringApplication.run(EcommerceSpringApplication.class, args);
    }

}
