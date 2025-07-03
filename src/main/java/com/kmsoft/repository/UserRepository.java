package com.kmsoft.repository;

import com.kmsoft.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	public User findById(int id);
	public User findByUserName(String userName);
	public User findByUserEmail(String email);
	public User findByUserNameAndPassword(String email,String pass);
	public User findByRoles(String role);
}


