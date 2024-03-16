package com.onlinestore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onlinestore.entity.Login;
import com.onlinestore.entity.Person;
import com.onlinestore.repository.LoginRepository;
import com.onlinestore.repository.PersonRepository;

@Service
public class PersonServiceImpl implements PersonService {

	private PersonRepository personRepository;
	private LoginRepository loginRepository;
	
	public PersonServiceImpl(PersonRepository personRepository, LoginRepository loginRepository) {
		this.personRepository = personRepository;
		this.loginRepository = loginRepository;
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<Person> listPersons(){
		return personRepository.findAll();
	}

	@Override
	public Optional<Person> findById(int id) {
		return personRepository.findById(id);
	}

	@Override
	public Person savePerson(Person person) {
		return personRepository.save(person);
	}

	@Override
	public void deleteById(int idPerson) {
		Optional<Person> person = findById(idPerson);
		Login login = person.get().getIdLogin();
		int idLogin = login.getIdLogin();
		
		personRepository.deleteById(idPerson);
		loginRepository.deleteById(idLogin);	
	}
}
