package com.rui.soares.springbootkafkaconsumer.annotations;

import com.rui.soares.springbootkafkaconsumer.config.ConsumerFactoryConfig;
import org.springframework.core.annotation.AliasFor;
import org.springframework.kafka.annotation.KafkaListener;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Custom annotation to simplify the usage of @KafkaListener.
 * It provides default values for topics, containerFactory, groupId, and errorHandler.
 * This annotation can be used to annotate methods that should listen to Kafka topics.
 *
 * @see KafkaListener
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@KafkaListener
public @interface KafkaListenerCustom {
    @AliasFor(annotation = KafkaListener.class, attribute = "topics")
    String[] topics() default ConsumerFactoryConfig.TOPIC;

    @AliasFor(annotation = KafkaListener.class, attribute = "containerFactory")
    String containerFactory() default ConsumerFactoryConfig.KAFKA_LISTENER_CONTAINER_FACTORY;

    @AliasFor(annotation = KafkaListener.class, attribute = "groupId")
    String groupId() default ConsumerFactoryConfig.GROUP_ID_ZERO;

    @AliasFor(annotation = KafkaListener.class, attribute = "errorHandler")
    String errorHandler() default "exceptionHandler";
}