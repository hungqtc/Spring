package com.hung.service.impls;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.hung.model.Person;
import com.hung.repository.PersonRepository;
import com.hung.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {
	 @Autowired
	 private PersonRepository personRepository;

	@Override
	public List<Person> getAllPerson() {
		return personRepository.findAll();
	}

	@Override
	public Person getById(Long id) {
		return personRepository.findOne(id);
	}

	@Override
	public Person add(Person person) {
		return personRepository.save(person);
	}

	@Override
	public void delete(Long personId) {
		personRepository.delete(personId);
	}

	@Override
	public Person edit(Person person, Long id) {
		Person oldPerson = personRepository.findOne(id);
		oldPerson.setFirstName(person.getFirstName());
		oldPerson.setLastName(person.getLastName());
		oldPerson.setAge(person.getAge());;
		
		return personRepository.save(oldPerson);
	}
	   
}
