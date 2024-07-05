package com.example.redisstudy.domain;


import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.data.redis.core.index.Indexed;

@Getter
@RedisHash("people")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Hello {

    @Id
    private String id;

    @Indexed
    private String name;

    private String value;

    private Address address;

    @TimeToLive
    public long getTimeToLive() {
        return 1L;
    }

    @Builder
    public Hello(String name, String value, String city) {
        this.name = name;
        this.value = value;
        this.address = new Address(city);
    }
}
