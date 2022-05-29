package com.kmsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kmsoft.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	public User findById(int id);
	public User findByUserName(String userName);
	public User findByUserEmail(String email);
	public User findByUserNameAndPassword(String email,String pass);
}


