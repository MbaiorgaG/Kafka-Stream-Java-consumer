package com.sdl.kafkastreamjavaconsumer.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaStreamConsumer {

    Logger logger  = LoggerFactory.getLogger(KafkaStreamConsumer.class);
    @KafkaListener(topics = "t_test")
    public String consumeMessage(String message){
        logger.info("Consumed Kafka Message {}", message);
        return message;
    }
}
