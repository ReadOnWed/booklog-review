package com.booklog.review.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(factory);

        //Optional: Serializer 설정
        redisTemplate.setKeySerializer(new StringRedisSerializer());

        // Jackson2JsonRedisSerializer : Jackson 라이브러리를 사용하여 Java 객체를 JSON 형식으로 직렬화/역직렬화
        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(Object.class));

        // Hash 키와 값에 대한 직렬화
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new StringRedisSerializer());

        return redisTemplate;
    }
}