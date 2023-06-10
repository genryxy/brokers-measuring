package ru.hse.babds.active.service;

import java.util.concurrent.atomic.AtomicInteger;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;
import ru.hse.babds.active.utils.CurrentSize;
import static ru.hse.babds.common.utils.MeasureLogs.consumeToLog;

@Component
@Slf4j
public class JmsConsumerStrings implements MessageListener {
    static AtomicInteger counter = new AtomicInteger();

    @Override
    @JmsListener(destination = "${active-mq.topic.strings}")
    public void onMessage(Message message) {
        try {
            TextMessage textMessage = (TextMessage) message;
            consumeToLog(counter, CurrentSize.DATA_SIZE);
//            log.info("Received Message from Strings: " + textMessage.getText());
        } catch (Exception e) {
            log.error("Received Exception while processing message: " + e);
        }
    }
}
