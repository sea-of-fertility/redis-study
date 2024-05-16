package com.example.redisstudy.repository;

import com.example.redisstudy.domain.Hello;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HelloRepository extends CrudRepository<Hello, String> {


}
