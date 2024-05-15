package com.example.redisstudy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@SpringBootApplication
@Slf4j
public class RedisStudyApplication {

    public static void main(String[] args) {


        SpringApplication.run(RedisStudyApplication.class, args);


        LettuceConnectionFactory connectionFactory = new LettuceConnectionFactory();

        connectionFactory.afterPropertiesSet();


        RedisTemplate<String, String> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        template.setDefaultSerializer(StringRedisSerializer.UTF_8);
        template.afterPropertiesSet();


        template.opsForValue().set("foo", "bar");

        log.info("Value at foo: {}", template.opsForValue().get("foo"));




    }

}
