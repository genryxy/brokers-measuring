package ru.hse.babds.rabbit.service;

import java.util.concurrent.atomic.AtomicInteger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import ru.hse.babds.common.CurrentSize;
import static ru.hse.babds.common.utils.MeasureLogs.consumeToLog;

@Slf4j
@Component
public class QueueConsumer {
    static AtomicInteger counter = new AtomicInteger();

    @RabbitListener(queues = {"${queue.name}"})
    public void receive(@Payload String fileBody) {
        consumeToLog(counter, CurrentSize.DATA_SIZE);
//        log.info("Received Message: " + fileBody);
    }

}
