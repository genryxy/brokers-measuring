package ru.hse.babds.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.hse.babds.common.CurrentSize;
import ru.hse.babds.common.DataSize;
import static ru.hse.babds.common.DataToSend.*;
import ru.hse.babds.kafka.service.KafkaProducerService;

@Controller
public class KafkaPublishController {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @GetMapping
    public ResponseEntity<String> getStatus() {
        return ResponseEntity.ok("it is working");
    }

    @GetMapping("send/1kb")
    public ResponseEntity<String> publishMsg1Kb() {
        CurrentSize.DATA_SIZE = DataSize.KAFKA_KB_1;
        kafkaProducerService.sendMessage(DATA_1_KB);
        return ResponseEntity.ok("published");
    }

    @GetMapping("send/10kb")
    public ResponseEntity<String> publishMsg10Kb() {
        CurrentSize.DATA_SIZE = DataSize.KAFKA_KB_10;
        kafkaProducerService.sendMessage(DATA_10_KB);
        return ResponseEntity.ok("published");
    }

    @GetMapping("send/100kb")
    public ResponseEntity<String> publishMsg100Kb() {
        CurrentSize.DATA_SIZE = DataSize.KAFKA_KB_100;
        kafkaProducerService.sendMessage(DATA_100_KB);
        return ResponseEntity.ok("published");
    }

    @GetMapping("send/1mb")
    public ResponseEntity<String> publishMsg1Mb() {
        CurrentSize.DATA_SIZE = DataSize.KAFKA_MB_1;
        kafkaProducerService.sendMessage(DATA_1_MB);
        return ResponseEntity.ok("published");
    }

    @GetMapping("send/10mb")
    public ResponseEntity<String> publishMsg10Mb() {
        CurrentSize.DATA_SIZE = DataSize.KAFKA_MB_10;
        kafkaProducerService.sendMessage(DATA_10_MB);
        return ResponseEntity.ok("published");
    }
}
