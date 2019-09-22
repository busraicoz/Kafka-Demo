package com.kafka.demo.controller;

import com.kafka.demo.entity.CityLog;
import com.kafka.demo.repository.CityLogRepository;
import com.kafka.demo.service.RandomLogGeneratorService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.verify;

@EnableAutoConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAsync
public class CityLogRestControllerTest {
    @Mock
    CityLogRepository cityLogRepository;

    @Test
    public void verify_show_all_city_logs_function() {
        CityLog cityLog = new CityLog();
        cityLog.setCityName("Istanbul");
        cityLog.setDate(RandomLogGeneratorService.getCurrentDate());
        cityLog.setMessage("Hello-from-Istanbul");
        cityLog.setSeverity("FATAL");
        cityLogRepository.save(cityLog);
        cityLogRepository.findAll();
        verify(cityLogRepository).findAll();
    }

}