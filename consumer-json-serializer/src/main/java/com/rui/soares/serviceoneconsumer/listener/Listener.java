package com.rui.soares.serviceoneconsumer.listener;

import com.rui.soares.request.UserRequest;
import com.rui.soares.serviceoneconsumer.config.ConsumerConfigFactory;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * Listener is responsible for consuming messages from the Kafka topic.
 * It listens to the topic-json and processes the messages.
 * The class contains three methods that handle different tasks:
 * 1. validateAddress: Validates the address of the user.
 * 2. pdfGenerator: Generates a PDF for the user.
 * 3. sendEmail: Sends an email to the user.
 */
@Log4j2
@RequiredArgsConstructor
@Component
public class Listener {
    /**
     * The topic name for payment messages.
     */
    public static final String PAYMENT_TOPIC = "topic-json";

    /**
     * The group ID for the Kafka consumer.
     */
    @SneakyThrows
    @KafkaListener(topics = PAYMENT_TOPIC, groupId = "validate-group", containerFactory = ConsumerConfigFactory.KAFKA_LISTENER_CONTAINER_FACTORY)
    public void validateAddress(@Payload UserRequest userRequest) {
        log.info("Validate address... {}", userRequest.toString());
        //Thread.sleep(2000);
    }

    /**
     * The group ID for the Kafka consumer.
     */
    @SneakyThrows
    @KafkaListener(topics = PAYMENT_TOPIC, groupId = "pdf-group", containerFactory = ConsumerConfigFactory.KAFKA_LISTENER_CONTAINER_FACTORY)
    public void pdfGenerator(@Payload UserRequest userRequest) {
        log.info("PDF generator. Email: {}", userRequest.getEmail());
        //Thread.sleep(3000);
    }

    /**
     * The group ID for the Kafka consumer.
     */
    @SneakyThrows
    @KafkaListener(topics = PAYMENT_TOPIC, groupId = "email-group", containerFactory = ConsumerConfigFactory.KAFKA_LISTENER_CONTAINER_FACTORY)
    public void sendEmail() {
        //Thread.sleep(4000);
        log.info("Email send.");
    }
}