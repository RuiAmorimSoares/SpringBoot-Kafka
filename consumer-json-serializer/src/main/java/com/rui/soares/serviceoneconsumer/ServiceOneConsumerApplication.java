package com.rui.soares.serviceoneconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class for the Service One Consumer application.
 * This application consumes the Service One API.
 */
@SpringBootApplication
public class ServiceOneConsumerApplication {
    /**
     * Main method to run the Service One Consumer application.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(ServiceOneConsumerApplication.class, args);
    }
}