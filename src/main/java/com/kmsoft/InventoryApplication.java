package com.kmsoft;

import com.kmsoft.model.Shop;
import com.kmsoft.model.User;
import com.kmsoft.repository.ShopRepository;
import com.kmsoft.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.time.LocalDate;
import java.util.Date;





@SpringBootApplication
public class InventoryApplication extends SpringBootServletInitializer {
	
@Autowired
UserRepository userRepo;

@Autowired
ShopRepository shopRepo;
	
//  @PostConstruct
//	  public void init(){
//
//	  User user=new User();
//		user.setUserName("kmsoftv1");
//		user.setUserId(1);
//		user.setRoles("system");
//
//		user.setPassword("tn52q0297");
//		userRepo.save(user);
//
//		boolean s=shopRepo.existsById(1);
//		if(s==false) {
//		Shop shop=new Shop();
//		shop.setShopid(1);
//		shop.setShopName("DemoShop");
//		LocalDate d=LocalDate.now();
//		LocalDate exp=d.plusDays(7);
//		shop.setExpirydate(exp);
//		 shopRepo.saveAndFlush(shop);
//		 }
//		else {
//
//		}
//	  }
  
//  @Override  
//  protected SpringApplicationBuilder configure(SpringApplicationBuilder application)   
//  {  
//  return application.sources(InventoryApplication.class);  
//  }  
  static Date date;
	
//	  @Override
//	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//	        return application.sources(InventoryApplication.class);
//	    }
	 
	  
	public static void main(String[] args) {
		
	
		SpringApplication.run(InventoryApplication.class, args);
		
		
		
		
		
	
		
		
	} 
	

}

