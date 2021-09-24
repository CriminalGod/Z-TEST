package com.example.demo.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.Person;

public interface PersonRepo extends CrudRepository<Person, Integer> {

}
