package com.example.redisstudy.service;


import com.example.redisstudy.domain.Hello;
import com.example.redisstudy.domain.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class RedisService {

    private final StringRedisTemplate stringRedisTemplate;

    public void save(Person person) {
        stringRedisTemplate.opsForValue().set(person.getFirstname(), person.getLastname(), 5L, TimeUnit.SECONDS);
    }

}
