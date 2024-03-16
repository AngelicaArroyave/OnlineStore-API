package com.onlinestore.entity;

import java.io.Serializable;

import com.onlinestore.enums.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Table(name = "login")
@Inheritance(strategy = InheritanceType.JOINED)
public class Login implements Serializable {

	private static final long serialVersionUID = 8781245800860467438L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idLogin")
	private int idLogin;
	
	@Column(name = "email", nullable = false, length = 100)
	private String email;
	
	@Column(name = "password", nullable = false, length = 10)
	private String password;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "role", nullable = false)
	private Role role;

	public int getIdLogin() {
		return idLogin;
	}

	public void setIdLogin(int idLogin) {
		this.idLogin = idLogin;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
