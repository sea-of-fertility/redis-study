package com.example.redisstudy;


import com.example.redisstudy.domain.Person;
import com.example.redisstudy.service.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final RedisService redisService;

    @PostMapping("/save")
    public void save(@RequestBody Person person) {
        redisService.save(person);
    }
}
