package com.example.redisstudy.domain;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;


@SpringBootTest
class PersonTest {

    @Test
    void test1() throws Exception {
        //given

        Person person = new Person();
        person.setFirstname("Dave");




        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnorePaths("lastname")
                .withIncludeNullValues()
                .withStringMatcher(ExampleMatcher.StringMatcher.ENDING);

        Example<Person> example = Example.of(person, matcher);
        //when

        //then
    }

}