package ru.hse.babds.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.hse.babds.kafka.service.KafkaProducerService;

@Controller
public class PublishController {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @GetMapping
    public ResponseEntity<String> publishMsg() {
        kafkaProducerService.sendMessage("my message");
        return ResponseEntity.ok("published");
    }

}
