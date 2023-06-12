package ru.hse.babds.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.hse.babds.common.CurrentSize;
import ru.hse.babds.common.DataSize;
import static ru.hse.babds.common.DataToSend.*;
import ru.hse.babds.redis.service.StringProducer;

@RestController
public class RedisPublishController {

    @Autowired
    private StringProducer stringProducer;

//    @Autowired
//    private StudentProducer studentProducer;

    @GetMapping
    public ResponseEntity<String> getStatus() {
        return ResponseEntity.ok("it is working");
    }

    @GetMapping("send/1kb")
    public ResponseEntity<String> publishMsg1Kb() {
        CurrentSize.DATA_SIZE = DataSize.REDIS_KB_1;
        stringProducer.send(DATA_1_KB);
        return ResponseEntity.ok("published");
    }

    @GetMapping("send/10kb")
    public ResponseEntity<String> publishMsg10Kb() {
        CurrentSize.DATA_SIZE = DataSize.REDIS_KB_10;
        stringProducer.send(DATA_10_KB);
        return ResponseEntity.ok("published");
    }

    @GetMapping("send/100kb")
    public ResponseEntity<String> publishMsg100Kb() {
        CurrentSize.DATA_SIZE = DataSize.KB_100;
        stringProducer.send(DATA_100_KB);
        return ResponseEntity.ok("published");
    }

    @GetMapping("send/1mb")
    public ResponseEntity<String> publishMsg1Mb() {
        CurrentSize.DATA_SIZE = DataSize.MB_1;
        stringProducer.send(DATA_1_MB);
        return ResponseEntity.ok("published");
    }

    @GetMapping("send/10mb")
    public ResponseEntity<String> publishMsg10Mb() {
        CurrentSize.DATA_SIZE = DataSize.MB_10;
        stringProducer.send(DATA_10_MB);
        return ResponseEntity.ok("published");
    }

    @GetMapping("hseQueue")
    public String sendToQueue() {
        stringProducer.send("test message");
        return "success";
    }

//    @PostMapping("/student")
//    public ResponseEntity<String> sendMessage(@RequestBody Student student) {
//        studentProducer.sendMessage(student);
//        return ResponseEntity.ok("Message sent successfully");
//    }
}
