package com.example.redisstudy.service;


import com.example.redisstudy.domain.Hello;
import com.example.redisstudy.domain.Person;
import com.example.redisstudy.repository.HelloRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class RedisService {

    private final StringRedisTemplate stringRedisTemplate;
    private final HelloRepository helloRepository;

    public void save(Person person) {
        stringRedisTemplate.opsForValue().set(person.getFirstname(), person.getLastname(), 5L, TimeUnit.SECONDS);
    }

    public void save(Hello hello) {
       helloRepository.save(hello);
    }
    public boolean exists(Hello hello) {
        return helloRepository.existsById(hello.getId());
    }

}
