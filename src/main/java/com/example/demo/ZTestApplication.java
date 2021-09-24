package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.service.PersonService;

@SpringBootApplication
public class ZTestApplication {
	
	@Autowired
	PersonService personService;

	public static void main(String[] args) {
		SpringApplication.run(ZTestApplication.class, args);
	}

}
