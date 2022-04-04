package com.kmsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kmsoft.model.UserRegistration;

@Repository
public interface RegistrationRepository extends JpaRepository<UserRegistration, Integer> {

	public UserRegistration findById(int id);
	public UserRegistration findByUserName(String userName);
	public UserRegistration findByUserEmail(String email);
	public UserRegistration findByUserNameAndPassword(String email,String pass);
}


