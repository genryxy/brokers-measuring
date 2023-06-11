package ru.hse.babds.artemis.service;

import java.util.concurrent.atomic.AtomicInteger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import ru.hse.babds.artemis.model.Person;
import ru.hse.babds.common.CurrentSize;
import static ru.hse.babds.common.utils.MeasureLogs.consumeToLog;

@Slf4j
@Component
public class ArtemisConsumer {
    static AtomicInteger counter = new AtomicInteger();

    @JmsListener(
        destination = "${jms.queue.destination}",
        containerFactory = "queueListenerContainerFactory"
    )
    public void receiveStringQueue(Message<String> message){
        consumeToLog(counter, CurrentSize.DATA_SIZE);
        log.info("Recieved Queue Message: " + message.getPayload());
    }

    @JmsListener(
        destination = "${jms.topic.destination}",
        containerFactory = "topicListenerContainerFactory"
    )
    public void receiveStringTopic(Message<String> message) {
        consumeToLog(counter, CurrentSize.DATA_SIZE);
        log.info("Recieved Topic Message: " + message.getPayload());
    }

//    @JmsListener(destination = "${jms.queue.destination}")
    public void receivePerson(Message<Person> message){
        consumeToLog(counter, CurrentSize.DATA_SIZE);
        log.info("Recieved Person: " + message.getPayload());
    }
}
