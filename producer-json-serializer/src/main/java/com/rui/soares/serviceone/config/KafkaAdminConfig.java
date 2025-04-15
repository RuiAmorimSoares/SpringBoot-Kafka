package com.rui.soares.serviceone.config;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

/**
 * KafkaAdminConfig is responsible for creating the KafkaAdmin bean and the topic.
 * The topic is created when the application starts.
 */
@RequiredArgsConstructor
@Configuration
public class KafkaAdminConfig {
    public static final String TOPIC_ONE = "topic-json";
    private final KafkaProperties kafkaProperties;

    @Bean
    public KafkaAdmin kafkaAdmin() {
        var configs = kafkaProperties.buildProducerProperties();
        configs.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, kafkaProperties.getBootstrapServers());
        return new KafkaAdmin(configs);
    }

    /**
     * KafkaAdmin.NewTopics is used to create new topics.
     * The topic is created when the application starts.
     *
     * @return KafkaAdmin.NewTopics bean
     */
    @Bean
    public KafkaAdmin.NewTopics topics() {
        return new KafkaAdmin.NewTopics(
                TopicBuilder.name(TOPIC_ONE)
                        .partitions(1)
                        //.replicas(1)
                        .build()
        );
    }
}