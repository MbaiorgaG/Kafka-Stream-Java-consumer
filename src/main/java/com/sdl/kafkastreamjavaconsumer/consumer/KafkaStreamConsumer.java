package com.sdl.kafkastreamjavaconsumer.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sdl.kafkastreamjavaconsumer.model.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaStreamConsumer {

    Logger logger  = LoggerFactory.getLogger(KafkaStreamConsumer.class);
    private ObjectMapper mapper = new ObjectMapper();
    @KafkaListener(topics = "t_test")
    public String consumeMessage(String message) throws JsonProcessingException {
        Employee employee = mapper.readValue(message, Employee.class);
        logger.info("The employee sent over is {}", employee.toString());
        return employee.toString();
    }
}
