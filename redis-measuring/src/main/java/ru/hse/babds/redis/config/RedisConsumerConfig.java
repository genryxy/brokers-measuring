package ru.hse.babds.redis.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import ru.hse.babds.redis.model.Student;
import ru.hse.babds.redis.service.StringConsumer;
import ru.hse.babds.redis.service.StudentConsumer;

@Configuration
public class RedisConsumerConfig {
    @Value("${redis.string.topic}")
    private String stringTopic;

    @Value("${redis.student.topic}")
    private String studentTopic;

    @Value("${redis.host}")
    private String redisHostName;

    @Value("${redis.port}")
    private Integer redisPort;

    @Bean
    public RedisMessageListenerContainer listenerContainer(
        MessageListenerAdapter listenerAdapter
//        RedisConnectionFactory connectionFactory
    ) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(jedisConnectionFactoryConsumer());
        container.addMessageListener(listenerAdapter, new PatternTopic(stringTopic));
        return container;
    }

    @Bean
    public JedisConnectionFactory jedisConnectionFactoryConsumer() {
        RedisStandaloneConfiguration redisConfig = new RedisStandaloneConfiguration();
        redisConfig.setHostName(redisHostName);
        redisConfig.setPort(redisPort);
        return new JedisConnectionFactory(redisConfig);
    }

    @Bean
    public MessageListenerAdapter listenerAdapter(StringConsumer consumer) {
        MessageListenerAdapter messageListenerAdapter = new MessageListenerAdapter(consumer);
        messageListenerAdapter.setSerializer(RedisSerializer.string());
        return messageListenerAdapter;
    }

//    @Bean
//    public RedisMessageListenerContainer studentListenerContainer(
//        MessageListenerAdapter studentListenerAdapter,
//        RedisConnectionFactory connectionFactory
//    ) {
//        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
//        container.setConnectionFactory(connectionFactory);
//        container.addMessageListener(listenerAdapter, new PatternTopic(studentTopic));
//        return container;
//    }

//    @Bean
//    public MessageListenerAdapter studentListenerAdapter(
//        StudentConsumer consumer,
//        Jackson2JsonRedisSerializer<Student> jackson2JsonRedisSerializer
//    ) {
//        MessageListenerAdapter messageListenerAdapter = new MessageListenerAdapter(consumer);
//        messageListenerAdapter.setSerializer(jackson2JsonRedisSerializer);
//        return messageListenerAdapter;
//    }
}
