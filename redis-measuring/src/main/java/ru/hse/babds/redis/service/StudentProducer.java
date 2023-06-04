package ru.hse.babds.redis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import ru.hse.babds.redis.model.Student;

@Component
public class StudentProducer {
    @Autowired
    private RedisTemplate<String, Student> redisTemplate;

    @Value("${redis.student.topic}")
    private String messageTopic;

    public void sendMessage(Student student) {
        System.out.println("Sending Student details: " + student);
        redisTemplate.convertAndSend(messageTopic, student);
    }
}
