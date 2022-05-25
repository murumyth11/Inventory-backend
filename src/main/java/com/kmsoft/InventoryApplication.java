package com.kmsoft;

import java.util.Date;
import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


@SpringBootApplication
public class InventoryApplication extends SpringBootServletInitializer {
//  @PostConstruct
//	  public void init(){
//	    
//	    TimeZone.setDefault(TimeZone.getTimeZone("IST"));
//	  }
  
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

