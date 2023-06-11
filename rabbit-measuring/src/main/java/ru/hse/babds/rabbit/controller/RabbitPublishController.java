package ru.hse.babds.rabbit.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hse.babds.common.CurrentSize;
import ru.hse.babds.common.DataSize;
import static ru.hse.babds.common.DataToSend.*;
import ru.hse.babds.rabbit.service.QueueSender;

@RestController
public class RabbitPublishController {
    @Autowired
    private QueueSender queueSender;

    @GetMapping("send/1kb")
    public ResponseEntity<String> publishMsg1Kb() {
        CurrentSize.DATA_SIZE = DataSize.KB_1;
        queueSender.send(DATA_1_KB);
        return ResponseEntity.ok("published");
    }

    @GetMapping("send/10kb")
    public ResponseEntity<String> publishMsg10Kb() {
        CurrentSize.DATA_SIZE = DataSize.KB_10;
        queueSender.send(DATA_10_KB);
        return ResponseEntity.ok("published");
    }

    @GetMapping("send/100kb")
    public ResponseEntity<String> publishMsg100Kb() {
        CurrentSize.DATA_SIZE = DataSize.KB_100;
        queueSender.send(DATA_100_KB);
        return ResponseEntity.ok("published");
    }

    @GetMapping("send/1mb")
    public ResponseEntity<String> publishMsg1Mb() {
        CurrentSize.DATA_SIZE = DataSize.MB_1;
        queueSender.send(DATA_1_MB);
        return ResponseEntity.ok("published");
    }

    @GetMapping("send/10mb")
    public ResponseEntity<String> publishMsg10Mb() {
        CurrentSize.DATA_SIZE = DataSize.MB_10;
        queueSender.send(DATA_10_MB);
        return ResponseEntity.ok("published");
    }

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
