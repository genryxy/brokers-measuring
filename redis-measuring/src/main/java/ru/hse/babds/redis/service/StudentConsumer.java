package ru.hse.babds.redis.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.hse.babds.redis.model.Student;

@Slf4j
@Component
public class StudentConsumer {
    public void handleMessage(Student student) {
        log.info("Consumer> " + student);
    }
}