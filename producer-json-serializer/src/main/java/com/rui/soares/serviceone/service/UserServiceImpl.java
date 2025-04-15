package com.rui.soares.serviceone.service;

import com.rui.soares.request.UserRequest;
import com.rui.soares.serviceone.config.KafkaAdminConfig;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * UserServiceImpl is responsible for handling user-related operations.
 * It implements the UserService interface and provides the implementation for the save method.
 * The save method sends a UserRequest object to a Kafka topic.
 */
@Log4j2
@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final KafkaTemplate<String, Serializable> kafkaTemplate;

    /**
     * Saves the given user request.
     * It sends the user request to a Kafka topic for processing.
     *
     * @param userRequest The user request to be saved.
     */
    @SneakyThrows
    @Override
    public void save(UserRequest userRequest) {
        log.info("Received user service : {}", userRequest);
        Thread.sleep(1000);

        log.info("Send user: {}", userRequest);
        kafkaTemplate.send(KafkaAdminConfig.TOPIC_ONE, userRequest);
    }
}