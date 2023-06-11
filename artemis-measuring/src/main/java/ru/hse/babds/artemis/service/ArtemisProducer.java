package ru.hse.babds.artemis.service;

import java.util.concurrent.atomic.AtomicInteger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import ru.hse.babds.artemis.model.Person;
import ru.hse.babds.common.CurrentSize;
import static ru.hse.babds.common.utils.MeasureLogs.produceToLog;

@Component
@Slf4j
public class ArtemisProducer {
    static AtomicInteger counter = new AtomicInteger();

    @Autowired
    JmsTemplate jmsTemplateArtemis;

    @Value("${jms.queue.destination}")
    String destinationQueue;

    @Value("${jms.topic.destination}")
    String destinationTopic;

    public void sendQueue(String msg) {
        produceToLog(counter, CurrentSize.DATA_SIZE);
        jmsTemplateArtemis.setPubSubDomain(false);
        jmsTemplateArtemis.convertAndSend(destinationQueue, msg);
        log.info("Send Message: " + msg);
    }

    public void sendTopic(String msg) {
        produceToLog(counter, CurrentSize.DATA_SIZE);
        jmsTemplateArtemis.convertAndSend(destinationTopic, msg);
//        log.info("Send Message: " + msg);
    }

    public void send(Person p) {
        jmsTemplateArtemis.convertAndSend(destinationQueue, p);
    }
}
