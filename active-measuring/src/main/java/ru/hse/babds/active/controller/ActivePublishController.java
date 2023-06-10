package ru.hse.babds.active.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.hse.babds.active.model.Employee;
import ru.hse.babds.active.service.JmsProducer;
import ru.hse.babds.active.utils.CurrentSize;
import ru.hse.babds.common.DataSize;
import static ru.hse.babds.common.DataToSend.*;

@Controller
public class ActivePublishController {

    @Autowired
    JmsProducer jmsProducer;

    @PostMapping(value = "/api/employee")
    public ResponseEntity<Employee> sendMessageActive(@RequestBody Employee employee) {
        jmsProducer.sendMessage(employee);
        return ResponseEntity.ok(employee);
    }

    @GetMapping
    public ResponseEntity<String> getStatus() {
        return ResponseEntity.ok("it is working");
    }

    @GetMapping("send/1kb")
    public ResponseEntity<String> publishMsg1Kb() {
        CurrentSize.DATA_SIZE = DataSize.KB_1;
        jmsProducer.sendMessage(DATA_1_KB);
        return ResponseEntity.ok("published");
    }

    @GetMapping("send/10kb")
    public ResponseEntity<String> publishMsg10Kb() {
        CurrentSize.DATA_SIZE = DataSize.KB_10;
        jmsProducer.sendMessage(DATA_10_KB);
        return ResponseEntity.ok("published");
    }

    @GetMapping("send/100kb")
    public ResponseEntity<String> publishMsg100Kb() {
        CurrentSize.DATA_SIZE = DataSize.KB_100;
        jmsProducer.sendMessage(DATA_100_KB);
        return ResponseEntity.ok("published");
    }

    @GetMapping("send/1mb")
    public ResponseEntity<String> publishMsg1Mb() {
        CurrentSize.DATA_SIZE = DataSize.MB_1;
        jmsProducer.sendMessage(DATA_1_MB);
        return ResponseEntity.ok("published");
    }

    @GetMapping("send/10mb")
    public ResponseEntity<String> publishMsg10Mb() {
        CurrentSize.DATA_SIZE = DataSize.MB_10;
        jmsProducer.sendMessage(DATA_10_MB);
        return ResponseEntity.ok("published");
    }
}
