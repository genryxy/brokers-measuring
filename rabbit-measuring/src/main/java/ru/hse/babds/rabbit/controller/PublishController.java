package ru.hse.babds.rabbit.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hse.babds.rabbit.service.QueueSender;

@RestController
public class PublishController {
    @Autowired
    private QueueSender queueSender;

    @GetMapping("hseQueue")
    public String sendToQueue() {
        queueSender.send("test message");
        return "success";
    }

    @GetMapping("hseExchange")
    public String sendToExchange() throws JsonProcessingException {
        queueSender.convertAndSend("hseExchange", "routing-key-hseQueue", "test message (exchange)");
        return "success";
    }
}
