package ru.hse.babds.kafka.service;

import java.util.concurrent.atomic.AtomicInteger;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;
import ru.hse.babds.common.CurrentSize;
import static ru.hse.babds.common.utils.MeasureLogs.produceToLog;

@Slf4j
public class KafkaProducerService {
    static AtomicInteger counter = new AtomicInteger();

    private KafkaTemplate<String, String> kafkaTemplate;

    private NewTopic stringTopic;

    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate, NewTopic stringTopic) {
        this.kafkaTemplate = kafkaTemplate;
        this.stringTopic = stringTopic;
    }

    public void sendMessage(String msg) {
//        kafkaTemplate.send(stringTopic.name(), msg);
        ListenableFuture<SendResult<String, String>> future;
        future = kafkaTemplate.send(stringTopic.name(), msg);
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onSuccess(SendResult<String, String> result) {
                long offset = result.getRecordMetadata().offset();
                produceToLog(counter, CurrentSize.DATA_SIZE);
//                log.info(
//                    "Sent message=[{}] with offset=[{}]",
//                    msg,
//                    result.getRecordMetadata().offset()
//                );
            }

            @Override
            public void onFailure(Throwable ex) {
                log.error("Unable to send message=[{}] due to: {}", msg, ex.getMessage());
            }
        });
    }
}
