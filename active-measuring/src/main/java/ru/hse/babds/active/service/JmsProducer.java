package ru.hse.babds.active.service;

import java.util.concurrent.atomic.AtomicInteger;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;
import ru.hse.babds.active.model.Employee;
import ru.hse.babds.common.CurrentSize;
import static ru.hse.babds.common.utils.MeasureLogs.produceToLog;

@Component
@Slf4j
public class JmsProducer {
    static AtomicInteger counter = new AtomicInteger();

    @Autowired
    JmsTemplate jmsTemplateActive;

    @Value("${active-mq.topic.employee}")
    private String topicEmployee;

    @Value("${active-mq.topic.strings}")
    private String topicStrings;

    public void sendMessage(Employee message) {
        try {
//            log.info("Attempting Send message to Topic: " + topicEmployee);
            jmsTemplateActive.convertAndSend(topicEmployee, message);
        } catch (Exception e) {
            log.error("Received Exception during send Message: ", e);
        }
    }

    public void sendMessage(String data) {
//        log.info("Attempting Send message to Topic: " + topicStrings);
        jmsTemplateActive.send(topicStrings, new MessageCreator() {
            @Override
            public Message createMessage(final Session session) throws JMSException {
                produceToLog(counter, CurrentSize.DATA_SIZE);
                return session.createTextMessage(data);
            }
        });
    }
}