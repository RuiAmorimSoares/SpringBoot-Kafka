package com.rui.soares.springbootkafkaproducer.config;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;

/**
 * KafkaConfigAdmin is used to create Kafka topics.
 * It is used to create Kafka topics with value of type String.
 */
@RequiredArgsConstructor
@Configuration
public class KafkaConfigAdmin {
    public static final String STR_TOPIC = "topic";
    private final KafkaProperties properties;

    @Bean
    public KafkaAdmin kafkaAdmin() {
        final var configs = new HashMap<String, Object>();
        // Configure the broker
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, properties.getBootstrapServers());
        return new KafkaAdmin(configs);
    }

    /**
     * KafkaAdmin.NewTopics is used to create Kafka topics.
     * It is used to create Kafka topics with value of type String.
     */
    @Bean
    public KafkaAdmin.NewTopics topics() {
        return new KafkaAdmin.NewTopics(
                TopicBuilder.name(STR_TOPIC)
                        .partitions(2)
                        .replicas(1)
                        .build()
        );
    }
}
