package com.example.redisstudy.service;


import com.example.redisstudy.domain.Hello;
import com.example.redisstudy.repository.HelloRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
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
    void save() throws Exception {
        //given
        Hello myName = Hello.builder()
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
                .name("myName")
                .value("100")
                .build();

        redisService.save(myName);
        Thread.sleep(2000L);

        Hello myName2 = Hello.builder()
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


    @Test
    @DisplayName("TTL 만료된지 확인")
    void test2() throws Exception {
        //given
        Hello myName = Hello.builder()
                .name("myName")
                .value("100")
                .build();
        redisService.save(myName);
        Thread.sleep(2000L);
        //when
        boolean exists = redisService.exists(myName);

        //then
        Assertions.assertThat(exists).isFalse();
    }

    @Test
    @DisplayName("indexes on nested elements")
    void test3() throws Exception {
        //given
        Hello myName = Hello.builder()
                .name("myName")
                .value("100")
                .city("tear")
                .build();
        redisService.save(myName);

        //then
        helloRepository.findByAddress_City("tear").forEach((data) -> System.out.printf(data.getId()));
        System.out.printf("\n");
        List<Hello> myName1 = helloRepository.findByName("myName");
    }
}