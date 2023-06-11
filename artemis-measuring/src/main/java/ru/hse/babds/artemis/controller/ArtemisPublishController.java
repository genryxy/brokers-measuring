package ru.hse.babds.artemis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.hse.babds.artemis.model.Person;
import ru.hse.babds.artemis.service.ArtemisProducer;
import ru.hse.babds.common.CurrentSize;
import ru.hse.babds.common.DataSize;
import static ru.hse.babds.common.DataToSend.*;

@Controller
public class ArtemisPublishController {

    @Autowired
    ArtemisProducer artemisProducer;

    @GetMapping
    public ResponseEntity<String> getStatus() {
        return ResponseEntity.ok("it is working");
    }

    @GetMapping("send/1kb")
    public ResponseEntity<String> publishMsg1Kb() {
        CurrentSize.DATA_SIZE = DataSize.KB_1;
        artemisProducer.sendTopic(DATA_1_KB);
        return ResponseEntity.ok("published");
    }

    @GetMapping("send/10kb")
    public ResponseEntity<String> publishMsg10Kb() {
        CurrentSize.DATA_SIZE = DataSize.KB_10;
        artemisProducer.sendTopic(DATA_10_KB);
        return ResponseEntity.ok("published");
    }

    @GetMapping("send/100kb")
    public ResponseEntity<String> publishMsg100Kb() {
        CurrentSize.DATA_SIZE = DataSize.KB_100;
        artemisProducer.sendTopic(DATA_100_KB);
        return ResponseEntity.ok("published");
    }

    @GetMapping("send/1mb")
    public ResponseEntity<String> publishMsg1Mb() {
        CurrentSize.DATA_SIZE = DataSize.MB_1;
        artemisProducer.sendTopic(DATA_1_MB);
        return ResponseEntity.ok("published");
    }

    @GetMapping("send/10mb")
    public ResponseEntity<String> publishMsg10Mb() {
        CurrentSize.DATA_SIZE = DataSize.MB_10;
        artemisProducer.sendTopic(DATA_10_MB);
        return ResponseEntity.ok("published");
    }

    @PostMapping(value = "/send/person")
    public ResponseEntity<String> produceArtemis(@RequestBody Person p) {
        artemisProducer.send(p);
        System.out.println("send person: " + p);
        return ResponseEntity.ok("person ok:" + p.toString());
    }
}
