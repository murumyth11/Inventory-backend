package com.kmsoft.service;
import com.kmsoft.model.UserRegistration;
public interface RegistrationService {
	
	public UserRegistration fetchByemail(String email);
	
	public UserRegistration fetchByusername(String userName);

	public  UserRegistration findByUserNameAndPassword(String tempusername, String temppassword) ;
		
		
	

}
