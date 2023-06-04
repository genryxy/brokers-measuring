package ru.hse.babds.redis.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import ru.hse.babds.redis.model.Student;
import ru.hse.babds.redis.service.StudentConsumer;

@Configuration
public class RedisConsumerConfig {
    @Value("${redis.student.topic}")
    private String studentTopic;

    @Bean
    public RedisMessageListenerContainer listenerContainer(
        MessageListenerAdapter listenerAdapter,
        RedisConnectionFactory connectionFactory
    ) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.addMessageListener(listenerAdapter, new PatternTopic(studentTopic));
        return container;
    }
    @Bean
    public MessageListenerAdapter listenerAdapter(
        StudentConsumer consumer,
        Jackson2JsonRedisSerializer<Student> jackson2JsonRedisSerializer
    ) {
        MessageListenerAdapter messageListenerAdapter = new MessageListenerAdapter(consumer);
        messageListenerAdapter.setSerializer(jackson2JsonRedisSerializer);
        return messageListenerAdapter;
    }
}
