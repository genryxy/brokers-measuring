package ru.hse.babds.active.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.hse.babds.active.service.JmsProducerActive;
import ru.hse.babds.active.model.Employee;
import static ru.hse.babds.common.DataToSend.*;

@Controller
public class ActivePublishController {

    @Autowired
    JmsProducerActive jmsProducerActive;

    @PostMapping(value = "/api/employee")
    public ResponseEntity<Employee> sendMessageActive(@RequestBody Employee employee) {
        jmsProducerActive.sendMessage(employee);
        return ResponseEntity.ok(employee);
    }

    @GetMapping
    public ResponseEntity<String> getStatus() {
        return ResponseEntity.ok("it is working");
    }

    @GetMapping("send/1kb")
    public ResponseEntity<String> publishMsg1Kb() {
        jmsProducerActive.sendMessage(DATA_1_KB);
        return ResponseEntity.ok("published");
    }

    @GetMapping("send/10kb")
    public ResponseEntity<String> publishMsg10Kb() {
        jmsProducerActive.sendMessage(DATA_10_KB);
        return ResponseEntity.ok("published");
    }

    @GetMapping("send/100kb")
    public ResponseEntity<String> publishMsg100Kb() {
        jmsProducerActive.sendMessage(DATA_100_KB);
        return ResponseEntity.ok("published");
    }

    @GetMapping("send/1mb")
    public ResponseEntity<String> publishMsg1Mb() {
        jmsProducerActive.sendMessage(DATA_1_MB);
        return ResponseEntity.ok("published");
    }

    @GetMapping("send/10mb")
    public ResponseEntity<String> publishMsg10Mb() {
        jmsProducerActive.sendMessage(DATA_10_MB);
        return ResponseEntity.ok("published");
    }
}
