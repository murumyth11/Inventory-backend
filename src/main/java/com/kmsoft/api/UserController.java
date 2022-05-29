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

import com.kmsoft.model.Shop;
import com.kmsoft.model.User;
import com.kmsoft.repository.ShopRepository;
import com.kmsoft.repository.UserRepository;
import com.kmsoft.service.UserService;

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
		
		User userreg=registrationrepo.findById(1);
		
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
