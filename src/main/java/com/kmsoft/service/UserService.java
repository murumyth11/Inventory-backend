package com.kmsoft.service;
import com.kmsoft.model.User;
public interface UserService {
	
	public User fetchByemail(String email);
	
	public User fetchByusername(String userName);

	public  User findByUserNameAndPassword(String tempusername, String temppassword) ;
		
		
	

}
