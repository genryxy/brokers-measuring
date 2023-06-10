package ru.hse.babds.kafka.service;

import org.springframework.kafka.annotation.KafkaListener;

public class KafkaConsumerService {
    @KafkaListener(topics = "stringTopic", groupId = "hse")
    public void listenGroupFoo(String message) {
//        System.out.println("Received Message in group hse: " + message);
    }
}
