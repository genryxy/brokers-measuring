package ru.hse.babds.kafka.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Slf4j
public class KafkaProducerService {
    private KafkaTemplate<String, String> kafkaTemplate;

    private NewTopic stringTopic;

    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate, NewTopic stringTopic) {
        this.kafkaTemplate = kafkaTemplate;
        this.stringTopic = stringTopic;
    }

    public void sendMessage(String msg) {
//        kafkaTemplate.send(stringTopic.name(), msg);
        ListenableFuture<SendResult<String, String>> future =
            kafkaTemplate.send(stringTopic.name(), msg);
        future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onSuccess(SendResult<String, String> result) {
                long offset = result.getRecordMetadata().offset();
                if (offset % 10 == 0) {
                    log.info("offset: {}", offset);
                }
                log.info(
                    "Sent message=[{}] with offset=[{}]",
                    msg,
                    result.getRecordMetadata().offset()
                );
            }

            @Override
            public void onFailure(Throwable ex) {
                log.error("Unable to send message=[{}] due to: {}", msg, ex.getMessage());
            }
        });
    }
}
