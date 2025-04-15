package com.rui.soares.springbootkafkaproducer.config;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

/**
 * ProducerFactoryConfig is used to create Kafka producers.
 * It is used to send messages to Kafka topics with value of type String.
 */
@RequiredArgsConstructor
@Configuration
public class ProducerFactoryConfig {
    private final KafkaProperties kafkaProperties;

    /**
     * ProducerFactory is used to create Kafka producers.
     * It is used to send messages to Kafka topics with value of type String.
     */
    @Bean
    public ProducerFactory<String, String> producerFactory() {
        final var configs = kafkaProperties.buildProducerProperties();
        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
        configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return new DefaultKafkaProducerFactory<>(configs);
    }

    /**
     * KafkaTemplate is used to send messages to Kafka topics with value of type String.
     * It is used to send messages to Kafka topics with value of type String.
     */
    @Bean
    public KafkaTemplate<String, String> kafkaTemplate(final ProducerFactory<String, String> producerFactory) {
        return new KafkaTemplate<>(producerFactory);
    }
}
