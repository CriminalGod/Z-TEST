package com.example.demo.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="person_table")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="person_id")
    private int id;
    
    @Column(name="first_name", length = 25, nullable = false)
    private String firstName;
    
    @Column(name="last_name")
    private String lastName;
    
    @Column(name="email", unique = true)
    private String email;
    
    @Column(name="creation_date")
    private Date creationDtae;
    
}
