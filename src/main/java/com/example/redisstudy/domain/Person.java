package com.example.redisstudy.domain;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Person {

    @Id
    private String id;
    private String firstname;
    private String lastname;

}
