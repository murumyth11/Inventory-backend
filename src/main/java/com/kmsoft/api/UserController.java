package com.kmsoft.api;

import com.kmsoft.model.User;
import com.kmsoft.repository.UserRepository;
import com.kmsoft.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
	
	@Autowired
	UserService registerationService;
	 
	
	
	
	@Autowired
	UserRepository registrationrepo;
	
	@CrossOrigin("*")
	@PostMapping("/register")
	public User registerUser(@RequestBody User user) throws Exception {
		
		String tempemail=user.getUserEmail();
		if(tempemail!=null && !"".equals(tempemail)) {
			
			User userObj=registerationService.fetchByemail(tempemail);
			if(userObj!=null) {
				throw new Exception("User with "+tempemail+"already exist");
			}
		}
		
		User userreg=registrationrepo.findByRoles("admin");
		
		User userobj=null;
		if(userreg==null)
		{userobj=registrationrepo.save(user);}
		else {
			throw new Exception("user already registered");
		}
		return userobj;
		
		
	}
	
	@CrossOrigin("*")
	@PostMapping("/registerRole")
	public User registerRole(@RequestBody User user) throws Exception{
		String tempUserName=user.getUserName();
if(tempUserName!=null && !"".equals(tempUserName)) {
			
			User userObj=registerationService.fetchByusername(tempUserName);
			if(userObj!=null) {
				throw new Exception("User with "+tempUserName+"already exist");
			}
		}
User userobj=null;
userobj=registrationrepo.save(user);
return userobj;


	}
	
	@CrossOrigin("*")
	@PostMapping("/login")
	public User login(@RequestBody User user) throws Exception {
	
		String tempemail=user.getUserEmail();
		String tempusername=user.getUserName();
		String temppassword=user.getPassword();
		
		User userObj=null;
		if( temppassword!=null && tempusername!=null) {
		 userObj=registerationService.findByUserNameAndPassword(tempusername, temppassword);}
		if(userObj==null) {
			throw new Exception ("wrong credentials");
		}
		return userObj;
	}
	@CrossOrigin("*")
	@GetMapping("/userRoles")
	public List<User> getAllUser(){
		return registrationrepo.findAll();
	}
	
	@CrossOrigin("*")
	@DeleteMapping("/userRoles/delete/{id}")
	public  void deleteUserRole(@PathVariable int id) {
		registrationrepo.deleteById(id);
	}

}
