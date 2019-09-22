package com.kafka.demo.service;

import com.kafka.demo.entity.CityLog;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

/**
 * Random City Log generator
 */
@Service
public class RandomLogGeneratorService {
    private static final Logger logger = Logger.getLogger(RandomLogGeneratorService.class);

    static CityLog createLogMessage() {
        String cityName = randomCityNameGenerater();
        CityLog cityLog = new CityLog();
        cityLog.setDate(getCurrentDate());
        cityLog.setSeverity(randomLogSeverityLevelsGenerater());
        cityLog.setCityName(cityName);
        cityLog.setMessage("Hello-from-" + cityName);
        logger.info(cityLog.toString());
        return cityLog;
    }

    public static String getCurrentDate() {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return myDateObj.format(myFormatObj);
    }

    private static String randomCityNameGenerater() {
        String[] cities = {"Istanbul", "Tokyo", "Moskow", "Beijing", "London"};
        Random random = new Random();
        int randomNumber = random.nextInt(5);//Generates number  range of 0-4
        return cities[randomNumber];
    }

    private static String randomLogSeverityLevelsGenerater() {
        String[] severityLevels = {"INFO", "WARN", "FATAL", "DEBUG", "ERROR"};
        Random random = new Random();
        int randomNumber = random.nextInt(5);//Generates number  range of 0-4
        return severityLevels[randomNumber];
    }

}
