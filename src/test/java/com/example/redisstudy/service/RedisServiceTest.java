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

    @BeforeEach
    void setRedisRepository() {
        helloRepository.deleteAll();
    }

    @Test
    void save() throws Exception {
        //given
        Hello myName = Hello.builder()
                .id("11")
                .name("myName")
                .value("100")
                .build();

        //when
        redisService.save(myName);

        //then
        Assertions.assertThat(helloRepository.findById("11")).isPresent();
    }


    @Test
    void test1() throws Exception {
        //given
        Hello myName = Hello.builder()
                .id("11")
                .name("myName")
                .value("100")
                .build();

        redisService.save(myName);
        Thread.sleep(2000L);

        Hello myName2 = Hello.builder()
                .id("12")
                .name("myName")
                .value("100")
                .build();
        redisService.save(myName2);
        //then
        Optional<Hello> byId = helloRepository.findById("11");
        Optional<Hello> byId2 = helloRepository.findById("12");
        Assertions.assertThat(byId.isPresent()).isEqualTo(false);

        Assertions.assertThat(byId2.isPresent()).isEqualTo(true);
    }

}