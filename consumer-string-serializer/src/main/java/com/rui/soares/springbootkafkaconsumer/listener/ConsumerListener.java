package com.rui.soares.springbootkafkaconsumer.listener;

import com.rui.soares.springbootkafkaconsumer.annotations.KafkaListenerCustom;
import com.rui.soares.springbootkafkaconsumer.config.ConsumerFactoryConfig;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Component;

/**
 * This class contains Kafka listeners that handle incoming messages from different topics and groups.
 * It uses the @KafkaListener annotation to define the methods that will listen to specific Kafka topics.
 * The methods are responsible for processing the received messages.
 */
@Log4j2
@Component
public class ConsumerListener {
    // Group Zero
    // Annotation customized to reduce a boilerplate code.
    @KafkaListenerCustom
    @SneakyThrows
    public void createUserOne(final String message) {
        log.info("Create User One : {}", message);
        throw new IllegalArgumentException("Exception...");
        // Process the message here
    }

    // Annotation-based listener for Kafka messages
    @KafkaListener(
            groupId = ConsumerFactoryConfig.GROUP_ID_ZERO,
            topics = ConsumerFactoryConfig.TOPIC,
            containerFactory = ConsumerFactoryConfig.KAFKA_LISTENER_CONTAINER_FACTORY
    )
    public void createUserTwo(final String message) {
        log.info("Create User Two : {}", message);
        // Process the message here
    }

    // Group one
    // Annotation customized to reduce a boilerplate code and overriding the groupId and topicPartitions and set the partitions.
    @KafkaListener(
            groupId = ConsumerFactoryConfig.GROUP_ID_ONE,
            topicPartitions = {
                    @TopicPartition(topic = ConsumerFactoryConfig.TOPIC, partitions = {"1"})
            }
    )
    public void logOne(final String message) {
        log.info("Log One : {}", message);
        // Process the message here
    }

    // Annotation customized to reduce a boilerplate code and overriding the groupId and topicPartitions and set the partitions.
    @KafkaListener(
            groupId = ConsumerFactoryConfig.GROUP_ID_ONE,
            topicPartitions = {
                    @TopicPartition(topic = ConsumerFactoryConfig.TOPIC, partitions = {"0"})
            }
    )
    public void logTwo(final String message) {
        log.info("Log Two : {}", message);
        // Process the message here
    }

    // Group Two
    // Annotation customized to reduce a boilerplate code and overriding the groupId and containerFactory.
    @KafkaListenerCustom(groupId = ConsumerFactoryConfig.GROUP_ID_TWO, containerFactory = ConsumerFactoryConfig.KAFKA_LISTENER_CONTAINER_FACTORY_VALIDATION)
    public void validateAddress(final String message) {
        log.info("Validate Address : {}", message);
        // Process the message here
    }
}