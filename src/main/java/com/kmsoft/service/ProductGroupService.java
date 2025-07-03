package com.kmsoft.service;

import com.kmsoft.model.ProductGroup;

import java.util.List;

public interface ProductGroupService {
	
	public List<ProductGroup> getAllProductGroup();
	
	public ProductGroup createpg(ProductGroup productgroup);
	
	public ProductGroup updatepg(ProductGroup productgroup);
	
	public void deleteProductgroup(int id);

}
