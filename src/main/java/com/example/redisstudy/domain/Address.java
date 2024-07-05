package com.example.redisstudy.domain;


import lombok.Getter;
import org.springframework.data.redis.core.index.Indexed;

@Getter
public class Address {

    @Indexed
    public String city;

    public Address(String city) {
        this.city = city;
    }
}
