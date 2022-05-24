package com.kmsoft.api;

import java.io.IOException;
import java.util.Optional;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kmsoft.model.PurchaseBill;
import com.kmsoft.model.Shop;
import com.kmsoft.repository.ShopRepository;

@RestController
public class shopController {
	
	@Autowired
	ShopRepository shopRepo;
	
	
	@CrossOrigin("*")
	@PostMapping("/shop")
	public Shop createShop(@RequestPart String data,@RequestPart MultipartFile Image) throws IOException {
		
		System.out.println(data);
		
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
	public Optional<Shop> getShop() {
		return shopRepo.findById(1);
	}

}
