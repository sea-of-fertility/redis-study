package com.example.redisstudy.service;


import com.example.redisstudy.domain.Hello;
import com.example.redisstudy.repository.HelloRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class RedisServiceTest {

    @Autowired
    RedisService redisService;
    @Autowired
    HelloRepository helloRepository;

//    @BeforeEach
//    void setRedisRepository() {
//        helloRepository.deleteAll();
//    }

    @Test
    void test1() throws Exception {
        //given
        Hello myName = Hello.builder()
                .id("11")
                .name("myName")
                .value("100")
                .build();

        redisService.save(myName);
        Thread.sleep(1000L);
        //then
        Optional<Hello> byId = helloRepository.findById("11");
//        Assertions.assertThat(byId.isPresent()).isEqualTo(false);
    }

}