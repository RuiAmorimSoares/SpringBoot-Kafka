package com.rui.soares.serviceone.config;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.io.Serializable;

/**
 * ProducerConfigFactory is responsible for creating the KafkaTemplate bean.
 * The KafkaTemplate bean is used to send messages to Kafka topics.
 */
@RequiredArgsConstructor
@Configuration
public class ProducerConfigFactory {
    private final KafkaProperties kafkaProperties;

    /**
     * ProducerFactory is used to create the KafkaTemplate bean.
     * The KafkaTemplate bean is used to send messages to Kafka topics.
     *
     * @return ProducerFactory bean
     */
    @Bean
    public ProducerFactory<String, Object> producerFactory() {
        final var configs = kafkaProperties.buildProducerProperties();
        // Configure the broker
        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
        configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return new DefaultKafkaProducerFactory<>(configs, new StringSerializer(), new JsonSerializer<>());
    }

    /**
     * KafkaTemplate is used to send messages to Kafka topics.
     * The KafkaTemplate bean is used to send messages to Kafka topics.
     * The kafkaTemplate is used to send messages to Kafka topics wih value of type JSON.
     *
     * @param producerFactory ProducerFactory bean
     * @return KafkaTemplate bean
     */
    @Bean
    public KafkaTemplate<String, Serializable> kafkaTemplate(final ProducerFactory producerFactory) {
        return new KafkaTemplate<>(producerFactory);
    }
}