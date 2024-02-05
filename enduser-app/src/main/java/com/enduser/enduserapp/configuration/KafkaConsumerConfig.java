package com.enduser.enduserapp.configuration;

import org.apache.kafka.clients.admin.*;
import org.slf4j.*;
import org.springframework.context.annotation.*;
import org.springframework.kafka.annotation.*;
import org.springframework.kafka.config.*;

import static com.enduser.enduserapp.constants.AppConstants.GROUP_ID;
import static com.enduser.enduserapp.constants.AppConstants.LOCATION_TOPIC_NAME;

@Configuration
public class KafkaConsumerConfig {
    @Bean
    public NewTopic topic() {
        return TopicBuilder.name(LOCATION_TOPIC_NAME).build();
    }

    private Logger logger = LoggerFactory.getLogger(KafkaConsumerConfig.class);
    @KafkaListener(topics = LOCATION_TOPIC_NAME, groupId = GROUP_ID)
    public void updatedLocation(String value) {
//we will recieve the location here, and we can do whatever we want, ie. save to db or do some operation
        logger.info("location recieved: "+ value);
    }
}
