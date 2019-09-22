package com.kafka.demo.service;

import com.kafka.demo.entity.CityLog;
import org.junit.Test;

import static org.junit.Assert.*;

public class RandomLogGeneratorServiceTest {

    @Test
    public void verify_create_log_message_function() {
        CityLog cityLog = RandomLogGeneratorService.createLogMessage();
        String currentDate = RandomLogGeneratorService.getCurrentDate();
        String cityLogDate = cityLog.getDate();
        assertEquals(cityLogDate, currentDate);
    }
}