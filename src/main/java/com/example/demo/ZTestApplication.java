package com.example.demo;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entities.Person;
import com.example.demo.service.PersonService;

@SpringBootApplication
public class ZTestApplication implements CommandLineRunner {

    @Autowired
    private PersonService personService;

    List<Person> persons = Arrays.asList(new Person("variable", "kumar", "variablekumar@gmail.com", new Date()),
		new Person("property", "kumar", "propertykumar@gmail.com", new Date()),
		new Person("argument", "kumar", "argumentkumar@gmail.com", new Date()));
    
    public static void main(String[] args) {
	SpringApplication.run(ZTestApplication.class, args);
    }

    private void createPerson() {
	Person person = new Person("kiran", "kumar", "kirankumar@gmail.com", new Date());
	Person p = personService.createPerson(person);
	System.out.println(p);
    }

    @Override
    public void run(String... args) throws Exception {
	clearData();
//	createPerson();
	createPersons();
    }

    private void clearData() {
	personService.clearData();
    }

    private void createPersons() {
	Iterable<Person> list = personService.createPersons(persons);
	list.forEach(System.out::println);
    }
    
}
