package com.example.redisstudy.repository;

import com.example.redisstudy.domain.Hello;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface HelloRepository extends CrudRepository<Hello, String> {

    List<Hello> findByAddress_City(String city);
    List<Hello> findByName(String name);

}
