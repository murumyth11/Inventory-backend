package com.kmsoft.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;

import com.kmsoft.model.ProductUpdateHistory;

public interface ProductUpdateHistoryService {
	
	public ProductUpdateHistory createProductUpdateHistory(ProductUpdateHistory productupdtHst);
	
	public Page<List<ProductUpdateHistory>> findAllById(int id,Pageable paging);
	
	public Page<List<ProductUpdateHistory>> findByUpdateDateContaining(String title,int id,Pageable paging);
	
	public int getSTockSold();

}
