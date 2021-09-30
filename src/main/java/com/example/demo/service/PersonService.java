package com.example.demo.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Person;
import com.example.demo.repo.PersonRepo;

@Service
public class PersonService {

	@Autowired
	PersonRepo personRepo;

	@Autowired
	EntityManager entityManager;

	public Person createPerson(Person person) {
		return personRepo.save(person);
	}

	public Iterable<Person> createPersons(List<Person> persons) {
		return personRepo.saveAll(persons);
	}

	public void clearData() {
		personRepo.deleteAll();
	}

	public Iterable<Person> getAllPersons() {
		return personRepo.findAll();
	}

	public List<Person> trail() {

		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Person> cq = cb.createQuery(Person.class);
		Root<Person> query = cq.from(Person.class);
		cq.select(query);
		cq.where(cb.equal(query.get("id"), 10));
		TypedQuery<Person> query1 = entityManager.createQuery(cq);
		return query1.getResultList();
	}
	
	public List<String> trail1() {

		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<String> cq = cb.createQuery(String.class);
		Root<Person> query = cq.from(Person.class);
		cq.select(query.get("email"));
//		cq.where(cb.equal(query.get("id"), 10));
		TypedQuery<String> query1 = entityManager.createQuery(cq);
		return query1.getResultList();
	}
	
	public void trailMultipleUsingSelect() {
		
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
		Root<Person> root = cq.from(Person.class);
		Path<Object> fname = root.get("firstName");
		Path<Object> lname = root.get("lastName");
		Path<Object> email = root.get("email");
		cq.select(cb.array(fname, lname, email));
		TypedQuery<Object[]> query = entityManager.createQuery(cq);
		query.getResultList().forEach(i -> {
			System.out.println(i[0]+" fname");
			System.out.println(i[1]+" lname");
			System.out.println(i[2]+" email");
			System.out.println(":::::::::");
		});;
	}
	
	public void trailMultipleUsingMultiSelect() {
		
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Object[]> cq = cb.createQuery(Object[].class);
		Root<Person> root = cq.from(Person.class);
		Path<Object> fname = root.get("firstName");
		Path<Object> lname = root.get("lastName");
		Path<Object> email = root.get("email");
//		cq.select(cb.array(fname, lname, email));
//		cq.select(cb.construct(PersonDTO.class, fname, lname, email));
		cq.multiselect(fname, lname, email);
		TypedQuery<Object[]> query = entityManager.createQuery(cq);
		query.getResultList().forEach(i -> {
			System.out.println(i[0]+" fname");
			System.out.println(i[1]+" lname");
			System.out.println(i[2]+" email");
			System.out.println(":::::::::");
		});;
	}
}