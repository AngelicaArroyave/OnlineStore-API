package com.onlinestore.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.onlinestore.entity.Login;
import com.onlinestore.repository.LoginRepository;

@Service
public class LoginServiceImpl implements LoginService {
	
	private LoginRepository loginRepository;
	
	public LoginServiceImpl(LoginRepository loginRepository) {
		this.loginRepository = loginRepository;
	}

	@Override
	public String findByEmail(String email) {
		return loginRepository.loginByEmail(email);
	}

	@Override
	public Login save(Login login) {
		return loginRepository.save(login);
	}

	@Override
	public Optional<Login> findById(int id) {
		return loginRepository.findById(id);
	}
}
