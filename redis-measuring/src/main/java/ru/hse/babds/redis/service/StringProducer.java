package ru.hse.babds.redis.service;

import java.util.concurrent.atomic.AtomicInteger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import ru.hse.babds.common.CurrentSize;
import static ru.hse.babds.common.utils.MeasureLogs.produceToLog;

@Slf4j
@Component
public class StringProducer {
    static AtomicInteger counter = new AtomicInteger();

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Value("${redis.string.topic}")
    private String messageTopic;

    public void send(String data) {
        produceToLog(counter, CurrentSize.DATA_SIZE);
//        log.info("Sending Data: " + data);
        redisTemplate.convertAndSend(messageTopic, data);
    }
}
