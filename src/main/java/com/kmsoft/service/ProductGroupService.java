package com.kmsoft.service;

import java.util.List;
import com.kmsoft.model.ProductGroup;

public interface ProductGroupService {
	
	public List<ProductGroup> getAllProductGroup();
	
	public ProductGroup createpg(ProductGroup productgroup);
	
	public ProductGroup updatepg(ProductGroup productgroup);
	
	public void deleteProductgroup(int id);

}
