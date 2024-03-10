package com.onlinestore.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "person")
@Inheritance(strategy = InheritanceType.JOINED)
public class Person implements Serializable {

	private static final long serialVersionUID = 706969743867578144L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPerson")
	private Long idPerson;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "lastname", nullable = false)
	private String lastname;
	
	@Column(name = "identification", nullable = false)
	private String identification;
	
	@Column(name = "phone", nullable = false)
	private String phone;
	
	@DateTimeFormat(pattern = "%Y-%m-%d")
	@Column(name = "birthdate", nullable = false)
	private Date birthdate;
	
	@Column(name = "country", nullable = false)
	private String country;
	
	@Column(name = "city", nullable = false)
	private String city;
	
	@ManyToOne
	@JoinColumn(name = "fk_idLogin", referencedColumnName = "idLogin")
	private Login idLogin;

	public Long getIdPerson() {
		return idPerson;
	}

	public void setIdPerson(Long idPerson) {
		this.idPerson = idPerson;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Login getIdLogin() {
		return idLogin;
	}

	public void setIdLogin(Login idLogin) {
		this.idLogin = idLogin;
	}
}
