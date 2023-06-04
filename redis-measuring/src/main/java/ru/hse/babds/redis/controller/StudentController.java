package ru.hse.babds.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.hse.babds.redis.model.Student;
import ru.hse.babds.redis.service.StudentProducer;

@RestController
public class StudentController {

    @Autowired
    private StudentProducer studentProducer;

    @PostMapping("/student")
    public ResponseEntity<String> sendMessage(@RequestBody Student student) {
        studentProducer.sendMessage(student);
        return ResponseEntity.ok("Message sent successfully");
    }
}
