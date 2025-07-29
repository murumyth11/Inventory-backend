package com.kmsoft.service;
import com.kmsoft.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService {
	
	public User fetchByemail(String email);
	
	public User fetchByusername(String userName);

	public  User findByUserNameAndPassword(String tempusername, String temppassword) ;
		
		
	

}
