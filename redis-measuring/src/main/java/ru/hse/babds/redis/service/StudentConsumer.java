package ru.hse.babds.redis.service;

import org.springframework.stereotype.Component;
import ru.hse.babds.redis.model.Student;

@Component
public class StudentConsumer {
    public void handleMessage(Student student) {
        System.out.println("Consumer> " + student);
    }
}