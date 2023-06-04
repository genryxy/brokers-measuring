package ru.hse.babds.active.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.hse.babds.active.service.JmsProducerActive;
import ru.hse.babds.active.model.Employee;

@Controller
public class ActivePublishController {

    @Autowired
    JmsProducerActive jmsProducerActive;

    @PostMapping(value = "/api/employee")
    public ResponseEntity<Employee> sendMessageActive(@RequestBody Employee employee) {
        jmsProducerActive.sendMessage(employee);
        return ResponseEntity.ok(employee);
    }
}
