package ru.hse.babds.kafka.service;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

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
                System.out.println("Sent message=[" + msg +
                    "] with offset=[" + result.getRecordMetadata().offset() + "]"
                );
            }

            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Unable to send message=["
                    + msg + "] due to : " + ex.getMessage()
                );
            }
        });
    }
}
