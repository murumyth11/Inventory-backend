package com.kmsoft;

import java.util.Date;
import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.kmsoft.model.UserRegistration;
import com.kmsoft.repository.RegistrationRepository;



@SpringBootApplication
public class InventoryApplication extends SpringBootServletInitializer {
	
	@Autowired
	RegistrationRepository regRepo;
	
  @PostConstruct
	  public void init(){
	    
	  UserRegistration user=new UserRegistration();
		user.setUserName("kmsoftv1");
		user.setUserId(1);
		user.setRoles("system");
		user.setPassword("tn52q0297");
		regRepo.save(user);
	  }
  
//  @Override  
//  protected SpringApplicationBuilder configure(SpringApplicationBuilder application)   
//  {  
//  return application.sources(InventoryApplication.class);  
//  }  
  static Date date;
	
	  @Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(InventoryApplication.class);
	    }
	 
	  
	public static void main(String[] args) {
		
	
		SpringApplication.run(InventoryApplication.class, args);
		
		
		
		
		
	
		
		
	} 
	

}

