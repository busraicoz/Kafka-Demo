package com.kafka.demo.service;

import com.kafka.demo.constants.IKafkaConstants;
import com.kafka.demo.consumer.ConsumerCreator;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.HashMap;


/**
 * Kafka Consumer Service
 */
@Service
public class LogConsumerService {
    private static final Logger logger = Logger.getLogger(LogConsumerService.class);

    /**
     * Consumer Service for city logs' record
     *
     * @return Cities's Log record counts
     */
    public HashMap<String, Integer> runLogConsumerService() {
        Consumer<String, String> consumer = ConsumerCreator.createConsumer();
        HashMap<String, Integer> cityLogCountMap = new HashMap<>();

        int messageNumber = 0;

        while (true) {
            final ConsumerRecords<String, String> consumerRecords = consumer.poll(IKafkaConstants.TIMEOUT);
            if (consumerRecords.count() == 0) {
                messageNumber++;
                if (messageNumber > IKafkaConstants.MAX_MESSAGE_COUNT)
                    break;
                else
                    continue;
            }
            consumerRecords.forEach(record -> {
                String keyCityName = record.key().split("-")[0];//Take city name for determine city's log record number
                logger.info("Record Key " + record.key());
                logger.info("Record value " + record.value());
                logger.info("Record partition " + record.partition());
                logger.info("Record offset " + record.offset());
                if (!cityLogCountMap.containsKey(keyCityName)) {
                    cityLogCountMap.put(keyCityName, 1);
                } else {
                    cityLogCountMap.put(keyCityName, cityLogCountMap.get(keyCityName) + 1);
                }
            });
            consumer.commitAsync();
        }
        consumer.close();
        return cityLogCountMap;
    }

}
