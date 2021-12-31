package com.kmsoft.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.kmsoft.model.ProductUpdateHistory;
import com.kmsoft.service.ProductUpdateHistoryService;


@RestController
public class ProductUpdateHistoryController {
   
	@Autowired
	ProductUpdateHistoryService puhService;
	

	@CrossOrigin("*")
	@PostMapping("/puh")
	public ProductUpdateHistory createProductUpdateHistory(@RequestBody ProductUpdateHistory productupdtHst) {
		return puhService.createProductUpdateHistory(productupdtHst);
	}
	
	@CrossOrigin("*")
	@GetMapping("/puh")
	public Page<List<ProductUpdateHistory>> getPuh(
		 @RequestParam(required = false) String title,
		 @RequestParam() int id,
	        @RequestParam(defaultValue = "0") int page,
	        @RequestParam(defaultValue = "2") int size
	      ) {
		 
	      Pageable paging = PageRequest.of(page, size);
	      Page<List<ProductUpdateHistory>> pageTuts;
	      
	      if(title==null)
	     
	      { pageTuts = puhService.findAllById(id,paging);
	      System.out.println(title);
	      return pageTuts;}
	     
	      else
	      {pageTuts=puhService.findByUpdateDateContaining(title,id, paging);
	      return pageTuts;}
	     
		}
	@CrossOrigin("*")
	@GetMapping("/products/stockSold")
	public int getStockSold() {
		return puhService.getSTockSold();
	}
}
