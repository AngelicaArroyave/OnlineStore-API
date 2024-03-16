package com.onlinestore.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onlinestore.entity.Login;
import com.onlinestore.service.LoginService;

@RestController
@RequestMapping("/api/login")
@CrossOrigin({"*"})
public class LoginController {

	private LoginService loginService;
	
	public LoginController(LoginService loginService) {
		this.loginService = loginService;
	}
	
	@PostMapping
	public ResponseEntity<?> saveLogin(@RequestBody Login login) {
		return ResponseEntity.status(HttpStatus.CREATED).body(loginService.save(login));
	}
	
	@GetMapping("/{email}")
	public ResponseEntity<?> findLoginByEmail(@PathVariable String email){
		String password = loginService.findByEmail(email);
		
		if(password.isEmpty()) return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok(password);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateLogin(@RequestBody Login detailsLogin, @PathVariable(value = "id") int idLogin) {
		Optional<Login> login = loginService.findById(idLogin);
		
		if(!login.isPresent()) return ResponseEntity.notFound().build();
		
		login.get().setEmail(detailsLogin.getEmail());
		login.get().setPassword(detailsLogin.getPassword());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(loginService.save(login.get()));
	}
}
