package com.rui.soares.serviceone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * ServiceOneApplication is the entry point of the Spring Boot application.
 * It starts the application and initializes the Spring context.
 */
@SpringBootApplication
public class ServiceOneApplication {
    /**
     * The main method is the entry point of the Spring Boot application.
     * It starts the application and initializes the Spring context.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(ServiceOneApplication.class, args);
    }

}