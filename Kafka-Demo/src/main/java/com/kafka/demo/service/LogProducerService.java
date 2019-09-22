package com.kafka.demo.service;

import com.kafka.demo.entity.CityLog;
import com.kafka.demo.producer.ProducerCreator;
import com.kafka.demo.constants.IKafkaConstants;
import com.kafka.demo.repository.CityLogRepository;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.concurrent.ExecutionException;

/**
 * Kafka  Producer service
 */
@Service
@Transactional
public class LogProducerService {
    private static final Logger logger = Logger.getLogger(LogProducerService.class);

    private static CityLogRepository cityLogRepository;

    public LogProducerService(CityLogRepository cityLogRepository) {
        LogProducerService.cityLogRepository = cityLogRepository;
    }

    /**
     * Save City Logs to city-log table in the database
     *
     * @param randomLog The log from city that we wish to save database
     */
    public void saveLogToDatabase(CityLog randomLog) {
        cityLogRepository.save(randomLog);
    }

    /**
     * Sending City log records to Kafka topic
     */
    public void sendLogMessageToKafka() {
        Producer<String, String> producer = ProducerCreator.createProducer();
        for (int index = 0; index < IKafkaConstants.MESSAGE_COUNT; index++) {
            CityLog cityLog = RandomLogGeneratorService.createLogMessage();//creating random log messages from RandomLogGeneratorService
            String value = cityLog.toString();
            String key = cityLog.getCityName() + "-" + index;
            final ProducerRecord<String, String> record = new ProducerRecord<>(IKafkaConstants.TOPIC_NAME, key, value);
            try {
                RecordMetadata metadata = producer.send(record).get();//send record to kafka topic
                saveLogToDatabase(cityLog);//save sended record to city_log table in database
                logger.info("Record sent with key " + key + " and value :" + value + " to partition " + metadata.partition()
                        + " with offset " + metadata.offset());
            } catch (ExecutionException | InterruptedException e) {
                logger.error("Error in sending record");
                logger.error(e);
            }
        }
    }
}


