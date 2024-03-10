package com.onlinestore.service;

import org.springframework.stereotype.Service;

import com.onlinestore.repository.LoginRepository;

@Service
public class LoginServiceImpl implements LoginService {
	
	private LoginRepository loginRepository;
	
	public LoginServiceImpl(LoginRepository loginRepository) {
		this.loginRepository = loginRepository;
	}

	@Override
	public String findByEmail(String email) {
		String password = loginRepository.loginByEmail(email);
		return password;
	}

}
