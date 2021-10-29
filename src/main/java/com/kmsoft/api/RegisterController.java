package com.kmsoft.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kmsoft.model.UserRegistration;
import com.kmsoft.repository.RegistrationRepository;
import com.kmsoft.service.RegistrationService;

@RestController
public class RegisterController {
	
	@Autowired
	RegistrationService registerationService;
	
	
	
	@Autowired
	RegistrationRepository registrationrepo;
	
	@CrossOrigin(origins = "*")
	@PostMapping("/register")
	public UserRegistration registerUser(@RequestBody UserRegistration user) throws Exception {
		
		String tempemail=user.getUserEmail();
		if(tempemail!=null && !"".equals(tempemail)) {
			
			UserRegistration userObj=registerationService.fetchByemail(tempemail);
			if(userObj!=null) {
				throw new Exception("User with "+tempemail+"already exist");
			}
		}
		UserRegistration userobj=null;
		userobj=registrationrepo.save(user);
		return userobj;
		
		
	}
	
	@CrossOrigin(origins = "*")
	@PostMapping("/login")
	public UserRegistration login(@RequestBody UserRegistration user) throws Exception {
		String tempemail=user.getUserEmail();
		String temppassword=user.getPassword();
		UserRegistration userObj=null;
		if(tempemail!=null && temppassword!=null) {
		 userObj=registerationService.findByUserEmailAndPassword(tempemail, temppassword);}
		if(userObj==null) {
			throw new Exception ("wrong credentials");
		}
		return userObj;
	}
	

}
