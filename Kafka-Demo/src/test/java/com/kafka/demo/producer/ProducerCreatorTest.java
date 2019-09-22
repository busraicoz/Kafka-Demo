package com.kafka.demo.producer;

import org.junit.Test;

import static org.junit.Assert.*;

public class ProducerCreatorTest {

    @Test
    public void verify_create_producer_function() {
        assertNotNull(ProducerCreator.createProducer());
    }

}