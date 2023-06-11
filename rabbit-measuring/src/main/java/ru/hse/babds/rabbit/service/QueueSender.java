package ru.hse.babds.rabbit.service;

import java.util.concurrent.atomic.AtomicInteger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.hse.babds.common.CurrentSize;
import static ru.hse.babds.common.utils.MeasureLogs.produceToLog;

@Slf4j
@Component
public class QueueSender {
    static AtomicInteger counter = new AtomicInteger();

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private Queue queue;

    public void send(String order) {
        produceToLog(counter, CurrentSize.DATA_SIZE);
        rabbitTemplate.convertAndSend(this.queue.getName(), order);
//        log.info("Send message: " + order);
    }

    public void convertAndSend(String exchange, String routingKey, String order) {
        rabbitTemplate.convertAndSend(exchange, routingKey, order);
    }
}
