package com.rui.soares.springbootkafkaproducer.controller;

import com.rui.soares.springbootkafkaproducer.service.ProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * ProducerController is a REST controller that handles HTTP requests for sending messages to a Kafka topic.
 * It uses the ProducerService to send messages.
 */
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/producer")
public class ProducerController {
    private final ProducerService producerService;

    /**
     * Send message is a POST endpoint that receives a message in the request body and sends it to the Kafka topic.
     *
     * @param message The message to be sent to the Kafka topic.
     * @return A ResponseEntity with status 201 (Created) if the message is sent successfully.
     */
    @PostMapping
    public ResponseEntity<?> sendMessage(@RequestBody String message) {
        producerService.send(message);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}