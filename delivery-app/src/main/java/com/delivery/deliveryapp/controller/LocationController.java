package com.delivery.deliveryapp.controller;

import com.delivery.deliveryapp.service.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/location")
public class LocationController {
    @Autowired
    private KafkaService service;

    private Logger logger = LoggerFactory.getLogger(KafkaService.class);

    @PostMapping("/update")
    public ResponseEntity<?> updateLocation() {
        for (int i = 0; i < 200000; i++) {
            service.updateLocation("(" + Math.round(Math.random() * 100) + " , " + Math.round(Math.random() * 100) + ")");
            logger.info("location sent");
        }

        return new ResponseEntity<>(Map.of("message", "location updated"), HttpStatus.OK);
    }
}
