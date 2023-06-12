package ru.hse.babds.redis.config;

import java.time.Duration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
public class RedisProducerConfig {
    @Value("${redis.host}")
    private String redisHostName;

    @Value("${redis.port}")
    private Integer redisPort;

    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        RedisStandaloneConfiguration redisConfig = new RedisStandaloneConfiguration();
        redisConfig.setHostName(redisHostName);
        redisConfig.setPort(redisPort);
        JedisClientConfiguration config = JedisClientConfiguration.builder()
            .connectTimeout(Duration.ofSeconds(300))
            .readTimeout(Duration.ofSeconds(300))
            .usePooling()
            .poolConfig(jedisPoolConfig())
            .build();
        return new JedisConnectionFactory(redisConfig, config);
    }

    @Bean
    public JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        JedisPoolConfig conf = new JedisPoolConfig();
        conf.setMaxTotal(1);
        conf.setTestOnBorrow(false);
        conf.setTestOnReturn(false);
        conf.setTestOnCreate(false);
        conf.setTestWhileIdle(false);
        conf.setMaxWait(Duration.ofSeconds(60));
        conf.setMinEvictableIdleTimeMillis(0);
        conf.setFairness(true);
        return conf;
    }

    @Bean
    public RedisTemplate<String, String> redisTemplate(
        RedisConnectionFactory jedisConnectionFactory
    ) {
        RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(jedisConnectionFactory);
        redisTemplate.setDefaultSerializer(RedisSerializer.string());
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

//    @Bean
//    public RedisTemplate<String, Student> redisTemplate(
//        RedisConnectionFactory jedisConnectionFactory,
//        Jackson2JsonRedisSerializer<Student> serializer
//    ) {
//        RedisTemplate<String, Student> redisTemplate = new RedisTemplate<>();
//        redisTemplate.setConnectionFactory(jedisConnectionFactory);
//        redisTemplate.setDefaultSerializer(serializer);
//        redisTemplate.afterPropertiesSet();
//        return redisTemplate;
//    }

//    @Bean
//    public Jackson2JsonRedisSerializer<Student> jackson2JsonRedisSerializer() {
//        return new Jackson2JsonRedisSerializer<>(Student.class);
//    }
}
