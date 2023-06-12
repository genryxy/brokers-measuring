package ru.hse.babds.redis.service;

import java.util.concurrent.atomic.AtomicInteger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.hse.babds.common.CurrentSize;
import static ru.hse.babds.common.utils.MeasureLogs.consumeToLog;

@Slf4j
@Component
public class StringConsumer {
    static AtomicInteger counter = new AtomicInteger();

    public void handleMessage(String data) {
        consumeToLog(counter, CurrentSize.DATA_SIZE);
//        log.info("Received message: " + data);
    }
}