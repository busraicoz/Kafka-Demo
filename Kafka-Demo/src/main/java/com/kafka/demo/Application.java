package com.kafka.demo;

import com.kafka.demo.service.LogProducerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Application main class
 */
@SpringBootApplication
public class Application {

    private static LogProducerService logProducerService;

    public Application(LogProducerService logProducerService) {
        Application.logProducerService = logProducerService;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        logProducerService.sendLogMessageToKafka();

    }


}