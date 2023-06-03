package ru.hse.babds.artemis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import ru.hse.babds.artemis.model.Person;

@Component
@EnableJms
public class ArtemisProducer {
    @Autowired
    JmsTemplate jmsTemplateArtemis;

    @Value("${jms.queue.destination}")
    String destinationQueue;

    public void send(String msg){
        jmsTemplateArtemis.convertAndSend(destinationQueue, msg);
    }

    public void send(Person p){
        jmsTemplateArtemis.convertAndSend(destinationQueue, p);
    }
}
