package com.kmsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kmsoft.model.UserRegistration;

public interface RegistrationRepository extends JpaRepository<UserRegistration, Integer> {

	
	public UserRegistration findByUserEmail(String email);
	public UserRegistration findByUserEmailAndPassword(String email,String pass);
}


