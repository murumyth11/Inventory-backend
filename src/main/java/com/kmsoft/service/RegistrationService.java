package com.kmsoft.service;

import org.springframework.stereotype.Service;

import com.kmsoft.model.UserRegistration;


public interface RegistrationService {
	
	public UserRegistration fetchByemail(String email);

	public  UserRegistration findByUserEmailAndPassword(String tempemail, String temppassword) ;
		
		
	

}
