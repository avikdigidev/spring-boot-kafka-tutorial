package com.delivery.deliveryapp.config;

import org.apache.kafka.clients.admin.*;
import org.springframework.context.annotation.*;
import org.springframework.kafka.config.*;

import static com.delivery.deliveryapp.constants.AppConstants.LOCATION_TOPIC_NAME;

@Configuration
public class KafkaConfig {


    @Bean
    public NewTopic topic() {
        return TopicBuilder.name(LOCATION_TOPIC_NAME).build();
    }
}
