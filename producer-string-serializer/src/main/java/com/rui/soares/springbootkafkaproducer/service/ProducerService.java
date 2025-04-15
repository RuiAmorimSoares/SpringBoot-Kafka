package com.rui.soares.springbootkafkaproducer.service;

import com.rui.soares.springbootkafkaproducer.config.KafkaConfigAdmin;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

/**
 * ProducerService is used to send messages to Kafka topics.
 * It uses KafkaTemplate to send messages to the topic.
 */
@Log4j2
@RequiredArgsConstructor
@Service
public class ProducerService {
    private final KafkaTemplate<String, String> kafkaTemplate;

    /**
     * Send is used to send messages to Kafka topics.
     * It uses KafkaTemplate to send messages to the topic.
     *
     * @param message the message to be sent
     */
    public void send(final String message) {
        // Send the message using KafkaTemplate
        final CompletableFuture<SendResult<String, String>> completableFuture = kafkaTemplate.send(KafkaConfigAdmin.STR_TOPIC, message);
        // Use whenComplete to handle both success and failure
        completableFuture.whenComplete((result, ex) -> {
            if (Objects.nonNull(ex)) {
                // Handle failure
                log.error("Message sending failed: {}", ex.getMessage());
            } else {
                // Handle success
                log.info("Message sent successfully: {}, partition: {}, offset: {}",
                        message,
                        result.getRecordMetadata().partition(),
                        result.getRecordMetadata().offset()
                );
            }
        });
    }
}