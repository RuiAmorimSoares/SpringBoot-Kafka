package com.rui.soares.springbootkafkaconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot application for Kafka consumer.
 * This application consumes messages from a Kafka topic.
 */
@SpringBootApplication
public class SpringbootKafkaConsumerApplication {
    /**
     * Main method to run the Spring Boot application.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(SpringbootKafkaConsumerApplication.class, args);
    }
}