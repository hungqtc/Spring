package com.hung.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hung.model.Person;
import com.hung.service.PersonService;

@RestController
public class PersonController {
	@Autowired
	PersonService personService;

	@GetMapping(value = "/person/{id}")
	public @ResponseBody Person getAllUsers(@PathVariable Long id) {
		return personService.getById(id);
	}

	@GetMapping(value = "/person")
	public List<Person> getAll() {
		return personService.getAllPerson();
	}

	@DeleteMapping(value = "/person/{id}")
	public void deletePersnone(@PathVariable Long id) {
		personService.delete(id);
	}

	@PostMapping(value = "/person")
	public Person insertPersone(@RequestBody Person person) {
		return personService.add(person);
	}

	@PutMapping(value = "/person/{id}")
	public Person editPerson(@RequestBody Person person, @PathVariable Long id) {
		return personService.edit(person ,id);
	}

}
