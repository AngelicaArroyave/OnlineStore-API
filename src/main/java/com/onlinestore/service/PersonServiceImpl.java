package com.onlinestore.service;

import org.springframework.stereotype.Service;

import com.onlinestore.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {

	private PersonRepository personRepository;
	
	public PersonServiceImpl(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
}
