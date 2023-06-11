package ru.hse.babds.kafka.service;

import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.kafka.annotation.KafkaListener;
import ru.hse.babds.common.CurrentSize;
import static ru.hse.babds.common.utils.MeasureLogs.consumeToLog;

public class KafkaConsumerService {
    static AtomicInteger counter = new AtomicInteger();

    @KafkaListener(topics = "stringTopic", groupId = "hse")
    public void listenGroupFoo(String message) {
        consumeToLog(counter, CurrentSize.DATA_SIZE);
//        System.out.println("Received Message in group hse: " + message);
    }
}
