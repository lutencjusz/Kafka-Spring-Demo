package com.example.demo;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class KafkaExampleConsumer {

    @KafkaListener(topics = "producer-example", groupId = "test-group-id")
    public void consume(@Payload String message) {
        System.out.println("Skonsumowany komunikat: " + message);
    }
}
