package com.example.redisstudy.domain;


import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

@Getter
@RedisHash
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Hello {

    @Id
    private String id;

    private String name;

    @Builder
    public Hello(String id, String name, String value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }

    private String value;

    @TimeToLive
    public Long expired = 15L;

}
