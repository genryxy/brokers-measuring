//package ru.hse.babds.redis.service;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.stereotype.Component;
//import ru.hse.babds.redis.model.Student;
//
//@Slf4j
//@Component
//public class StudentProducer {
//    @Autowired
//    private RedisTemplate<String, Student> redisTemplate;
//
//    @Value("${redis.student.topic}")
//    private String messageTopic;
//
//    public void sendMessage(Student student) {
//        log.info("Sending Student details: " + student);
//        redisTemplate.convertAndSend(messageTopic, student);
//    }
//}
