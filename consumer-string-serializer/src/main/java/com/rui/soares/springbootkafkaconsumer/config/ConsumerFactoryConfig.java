package com.rui.soares.springbootkafkaconsumer.config;

import org.apache.kafka.common.serialization.StringDeserializer;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.RecordInterceptor;

/**
 * ConsumerFactoryConfig is a configuration class that sets up the Kafka consumer factory and listener container factory.
 * It defines the properties for the Kafka consumer, including deserializers and bootstrap servers.
 * It also provides a record interceptor to validate messages before processing.
 */
@Log4j2
@RequiredArgsConstructor
@Configuration
public class ConsumerFactoryConfig {
    /**
     * Kafka group ID for the first consumer group.
     * This is used to identify the consumer group in Kafka.
     */
    public static final String GROUP_ID_ZERO = "group-0";
    /**
     * Kafka group ID for the first consumer group.
     * This is used to identify the consumer group in Kafka.
     */
    public static final String GROUP_ID_ONE = "group-1";
    /**
     * Kafka group ID for the first consumer group.
     * This is used to identify the consumer group in Kafka.
     */
    public static final String GROUP_ID_TWO = "group-2";
    /**
     * Kafka topic name.
     * This is the topic that the consumer will listen to for messages.
     */
    public static final String TOPIC = "topic";
    /**
     * Kafka listener container factory for default consumers.
     * This factory is used to create Kafka listeners with default configurations.
     */
    public static final String KAFKA_LISTENER_CONTAINER_FACTORY = "kafkaListenerContainerFactory";
    /**
     * Kafka listener container factory for validation.
     * This factory is used to create Kafka listeners with a record interceptor for message validation.
     */
    public static final String KAFKA_LISTENER_CONTAINER_FACTORY_VALIDATION = "kafkaListenerContainerFactoryValidation";

    private final KafkaProperties kafkaProperties;

    /**
     * Creates a ConsumerFactory for Kafka consumers.
     * It configures the consumer properties, including bootstrap servers and deserializers.
     *
     * @return a ConsumerFactory for Kafka consumers
     */
    @Bean
    public ConsumerFactory<String, String> consumerFactory() {
        final var configs = kafkaProperties.buildConsumerProperties();
        configs.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
        configs.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configs.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        return new DefaultKafkaConsumerFactory<>(configs);
    }

    /**
     * Creates a ConcurrentKafkaListenerContainerFactory for Kafka consumers.
     * It sets the consumer factory and configures the container factory.
     *
     * @param consumerFactory the ConsumerFactory to be used
     * @return a ConcurrentKafkaListenerContainerFactory for Kafka consumers
     */
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory(
            final ConsumerFactory<String, String> consumerFactory
    ) {
        var concurrentKafkaListenerContainerFactory = new ConcurrentKafkaListenerContainerFactory<String, String>();
        concurrentKafkaListenerContainerFactory.setConsumerFactory(consumerFactory);
        return concurrentKafkaListenerContainerFactory;
    }

    /**
     * Creates a ConcurrentKafkaListenerContainerFactory for Kafka consumers with validation.
     * It sets the consumer factory and configures the container factory with a record interceptor for message validation.
     *
     * @param consumerFactory the ConsumerFactory to be used
     * @return a ConcurrentKafkaListenerContainerFactory for Kafka consumers with validation
     */
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactoryValidation(
            final ConsumerFactory<String, String> consumerFactory
    ) {
        var concurrentKafkaListenerContainerFactory = new ConcurrentKafkaListenerContainerFactory<String, String>();
        concurrentKafkaListenerContainerFactory.setConsumerFactory(consumerFactory);
        concurrentKafkaListenerContainerFactory.setRecordInterceptor(validMessage());
        return concurrentKafkaListenerContainerFactory;
    }

    /**
     * Creates a RecordInterceptor for validating messages before processing.
     * It checks if the message contains the word "hello" (case-insensitive).
     *
     * @return a RecordInterceptor for message validation
     */
    private RecordInterceptor<String, String> validMessage() {
        return (record, consumer) -> {
            if (record.value().toLowerCase().contains("hello")) {
                log.info("Message contains 'hello': {}", record.value());
                return record;
            }
            return record;
        };
    }
}