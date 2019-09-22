package com.kafka.demo.consumer;

import org.junit.Test;

import static org.junit.Assert.*;

public class ConsumerCreatorTest {
    @Test
    public void verify_create_consumer_function() {
        assertNotNull(ConsumerCreator.createConsumer());
    }

}