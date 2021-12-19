package com.kmsoft.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
		
		UserRegistration userreg=registrationrepo.findById(1);
		
		UserRegistration userobj=null;
		if(userreg==null)
		{userobj=registrationrepo.save(user);}
		else {
			throw new Exception("user already registered");
		}
		return userobj;
		
		
	}
	
	@CrossOrigin("*")
	@PostMapping("/registerRole")
	public UserRegistration registerRole(@RequestBody UserRegistration user) throws Exception{
		String tempUserName=user.getUserName();
if(tempUserName!=null && !"".equals(tempUserName)) {
			
			UserRegistration userObj=registerationService.fetchByusername(tempUserName);
			if(userObj!=null) {
				throw new Exception("User with "+tempUserName+"already exist");
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
		String tempusername=user.getUserName();
		String temppassword=user.getPassword();
		System.out.println(tempusername);
		UserRegistration userObj=null;
		if( temppassword!=null && tempusername!=null) {
		 userObj=registerationService.findByUserNameAndPassword(tempusername, temppassword);}
		if(userObj==null) {
			throw new Exception ("wrong credentials");
		}
		return userObj;
	}
	@CrossOrigin("*")
	@GetMapping("/userRoles")
	public List<UserRegistration> getAllUser(){
		return registrationrepo.findAll();
	}
	
	@CrossOrigin("*")
	@DeleteMapping("/userRoles/delete/{id}")
	public  void deleteUserRole(@PathVariable int id) {
		registrationrepo.deleteById(id);
	}

}
