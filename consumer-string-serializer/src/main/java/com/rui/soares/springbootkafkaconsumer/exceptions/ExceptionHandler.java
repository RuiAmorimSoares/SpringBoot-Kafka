package com.rui.soares.springbootkafkaconsumer.exceptions;

import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/**
 * This class handles exceptions that occur during the processing of Kafka messages.
 * It implements the KafkaListenerErrorHandler interface and provides a custom error handling logic.
 */
@Log4j2
@Component
public class ExceptionHandler implements KafkaListenerErrorHandler {

    @Override
    public Object handleError(
            final Message<?> message,
            final ListenerExecutionFailedException exception
    ) {
        log.error("Error occurred while processing message: {} : {}", message, exception.getMessage());
        log.error("Payload: {}", message.getPayload());
        log.error("Headers: {}", message.getHeaders());
        log.error("Offset: {}", message.getHeaders().get("kafka_offset"));
        log.error("Message exception: {}", exception.getMessage());

        return null;
    }
}
