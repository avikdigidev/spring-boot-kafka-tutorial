package com.delivery.deliveryapp.service;

import org.springframework.beans.factory.annotation.*;
import org.springframework.kafka.core.*;
import org.springframework.stereotype.*;

import static com.delivery.deliveryapp.constants.AppConstants.LOCATION_TOPIC_NAME;

@Service
public class KafkaService {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public boolean updateLocation(String location) {

        this.kafkaTemplate.send(LOCATION_TOPIC_NAME, location);
        return true;
    }
}
