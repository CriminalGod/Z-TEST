package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Person;
import com.example.demo.repo.PersonRepo;

@Service
public class PersonService {

    @Autowired
    PersonRepo personRepo;

    public Person createPerson(Person person) {
	return personRepo.save(person);
    }

    public Iterable<Person> createPersons(List<Person> persons) {
	return personRepo.saveAll(persons);
    }

    public void clearData() {
	personRepo.deleteAll();
    }
}