package com.onlinestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.onlinestore.entity.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> {

	@Query(value = "SELECT l.password FROM person AS p JOIN login AS l ON p.idLogin = l.idLogin AND l.email = :email", nativeQuery = true)
	String loginByEmail(String email);
}
