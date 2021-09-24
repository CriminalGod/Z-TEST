package com.example.demo;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entities.Person;
import com.example.demo.service.PersonService;

@SpringBootApplication
public class ZTestApplication implements CommandLineRunner{

    @Autowired
    private PersonService personService;

	public static void main(String[] args) {
		SpringApplication.run(ZTestApplication.class, args);
	}

	private void createPerson() 
{
	    
	    Person person = new Person("ram","kumar","ramkumar@gmail.com", new Date());
	    System.out.println(person);
	    personService.createPerson(person);
		
	}

	@Override
	public void run(String... args) throws Exception {
	    
	}

}
