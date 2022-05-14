package com.kmsoft;

import java.util.Date;
import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class InventoryApplication extends SpringBootServletInitializer {

	

	 
	  @PostConstruct
	  public void init(){
	    // Setting Spring Boot SetTimeZone
	    TimeZone.setDefault(TimeZone.getTimeZone("IST"));
	  }
	  
	static Date date;
	public static void main(String[] args) {
		SpringApplication.run(InventoryApplication.class, args);
	System.out.println(System.currentTimeMillis());
		//hai this is main
		
	} 
	

}
