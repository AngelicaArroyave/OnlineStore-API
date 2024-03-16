package com.onlinestore.service;

import java.util.List;
import java.util.Optional;

import com.onlinestore.entity.Login;
import com.onlinestore.entity.Person;

public interface PersonService {
	
	public Person savePerson(Person person);
	
	public Optional<Person> findById(int id);

	public List<Person> listPersons();
	
	public void deleteById(int id);
}
