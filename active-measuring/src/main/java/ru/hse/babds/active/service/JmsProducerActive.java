package ru.hse.babds.active.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import ru.hse.babds.active.model.Employee;

@Component
@Slf4j
public class JmsProducerActive {

    @Autowired
    JmsTemplate jmsTemplateActive;

    @Value("${active-mq.topic}")
    private String topic;

    public void sendMessage(Employee message){
        try{
            log.info("Attempting Send message to Topic: "+ topic);
            jmsTemplateActive.convertAndSend(topic, message);
        } catch(Exception e){
            log.error("Received Exception during send Message: ", e);
        }
    }

    public void sendMessage(String data){
        try{
            log.info("Attempting Send message to Topic: "+ topic);
            jmsTemplateActive.convertAndSend(topic, data);
        } catch(Exception e){
            log.error("Received Exception during send Message: ", e);
        }
    }
}