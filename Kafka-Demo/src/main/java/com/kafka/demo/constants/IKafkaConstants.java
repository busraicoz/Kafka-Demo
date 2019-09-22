package com.kafka.demo.constants;

public interface IKafkaConstants {
    String KAFKA_BROKERS = "localhost:9092";

    Integer MESSAGE_COUNT = 200;

    Integer MAX_MESSAGE_COUNT = 200;

    Integer TIMEOUT = 100;

    String CLIENT_ID = "busraicoz";

    String TOPIC_NAME = "cityLogs";

    String GROUP_ID_CONFIG = "cityLogGroup";

    String OFFSET_RESET_EARLIER = "earliest";

    Integer MAX_POLL_RECORDS = 1;
}
