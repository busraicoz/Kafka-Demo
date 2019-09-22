package com.kafka.demo.controller;

import com.kafka.demo.entity.CityLog;
import com.kafka.demo.service.LogConsumerService;
import com.kafka.demo.service.LogProducerService;
import com.kafka.demo.repository.CityLogRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**
 * Rest Controller class City Logs
 */
@RestController
public class CityLogRestController {

    private LogConsumerService logConsumerService;
    private LogProducerService logProducerService;
    private CityLogRepository cityLogRepository;

    public CityLogRestController(LogConsumerService logConsumerService, LogProducerService logProducerService, CityLogRepository cityLogRepository) {
        this.logConsumerService = logConsumerService;
        this.logProducerService = logProducerService;
        this.cityLogRepository = cityLogRepository;
    }

    /**
     * @return List all records which located city log table in database
     */
    @GetMapping("/allData")
    public ResponseEntity<List<CityLog>> showAllCityLogs() {

        return ResponseEntity.ok(cityLogRepository.findAll());
    }

    /**
     * @return Post service for sending city log messages to kafka topic
     */
    @PostMapping("/sendData")
    public ResponseEntity sendCityLogData() {

        logProducerService.sendLogMessageToKafka();
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    /**
     * @return Get service for consume city log messages from kafka topic
     */
    @GetMapping("/consumeData")
    public ResponseEntity<HashMap<String, Integer>> consumeCityLogData() {
        logConsumerService.runLogConsumerService();
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
