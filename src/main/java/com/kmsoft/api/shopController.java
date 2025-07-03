package com.kmsoft.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kmsoft.model.Shop;
import com.kmsoft.repository.ShopRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;

@RestController
public class shopController {
	
	@Autowired
	ShopRepository shopRepo;
	
	
	@CrossOrigin("*")
	@PostMapping("/shop")
	public Shop createShop(@RequestPart String data,@RequestPart MultipartFile Image) throws IOException {
		
		
		
		String sb=data;
	ObjectMapper objectMapper=new ObjectMapper();
	JSONObject jsonObject=new JSONObject(sb);
	
	Shop shop=new Shop();
	
	
		 shop=objectMapper.readValue(data.toString(), Shop.class);
		 if(Image!=null)
		 { shop.setShoplogo(Image.getBytes());}
		 
		return shopRepo.save(shop);
	}
	
	
	
	@CrossOrigin("*")
	@GetMapping("/shop")
	public Shop getShop() {
		return shopRepo.findById(1).get();
	}
	
	@CrossOrigin("*")
	@GetMapping("/expiry")
	public boolean checkExpiry() {
	   
	 LocalDate d=LocalDate.now();
	  Shop s=shopRepo.getOne(1);
	  LocalDate exdate=s.getExpirydate();
	  
	 boolean isbefore;
	 
	 
	
	 
	  
	 if( d.isBefore(exdate)) {
		 return true;
	 }
	 else  {
		return false;
	}
		 
	 
	 
	
	
		
	}

}
