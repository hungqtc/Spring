package com.hung.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hung.model.Person;

public interface PersonService {
	
	List<Person> getAllPerson();
	
	Person getById(Long id);
	
	Person add(Person person);
	
	Person edit(Person person, Long id);
	  
	void delete(Long personId);
	 
}
