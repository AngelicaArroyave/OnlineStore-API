package com.onlinestore.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinestore.entity.Login;
import com.onlinestore.entity.Person;
import com.onlinestore.service.PersonService;

@RestController
@RequestMapping("/api/person")
@CrossOrigin({"*"})
public class PersonController {

	private PersonService personService;
	
	public PersonController(PersonService personService) {
		this.personService = personService;
	}
	
	@PostMapping
	public ResponseEntity<?> savePerson(@RequestBody Person person) {
		return ResponseEntity.status(HttpStatus.CREATED).body(personService.savePerson(person));
	}
	
	@GetMapping("/")
	public ResponseEntity<?> listAllPersons() {
		List<Person> listPersons = personService.listPersons();
		
		if(listPersons.isEmpty()) return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(listPersons);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletePerson(@PathVariable(value = "id") int idPerson) {
		if(!personService.findById(idPerson).isPresent()) return ResponseEntity.notFound().build();
		
		personService.deleteById(idPerson);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updatePerson(@RequestBody Person detailsPerson, @PathVariable(value = "id") int idPerson) {
		Optional<Person> person = personService.findById(idPerson);
		
		if(!person.isPresent()) return ResponseEntity.notFound().build();
		
		person.get().setName(detailsPerson.getName());
		person.get().setLastname(detailsPerson.getLastname());
		person.get().setIdentification(detailsPerson.getIdentification());
		person.get().setPhone(detailsPerson.getPhone());
		person.get().setBirthdate(detailsPerson.getBirthdate());
		person.get().setCountry(detailsPerson.getCountry());
		person.get().setCity(detailsPerson.getCity());
				
		return ResponseEntity.status(HttpStatus.CREATED).body(personService.savePerson(person.get()));
	}
}
