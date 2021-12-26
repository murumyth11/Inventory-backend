package com.kmsoft.service;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.kmsoft.model.ProductGroup;

public interface ProductGroupService {
	
	public List<ProductGroup> getAllProductGroup();
	
	public ProductGroup createpg(ProductGroup productgroup);
	
	public ProductGroup updatepg(ProductGroup productgroup);
	
	public void deleteProductgroup(int id);

}
