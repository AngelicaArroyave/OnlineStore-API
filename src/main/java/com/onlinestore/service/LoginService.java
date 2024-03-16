package com.onlinestore.service;

import java.util.Optional;

import com.onlinestore.entity.Login;

public interface LoginService {

	public String findByEmail(String email);
	
	public Login save(Login login);
	
	public Optional<Login> findById(int id);
}
