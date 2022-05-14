package com.kmsoft.service;

import java.util.List;
import java.util.Map;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.kmsoft.model.Product;



public interface ProductService {
		
public Product createProduct(Product product);
	
	public Product updateProduct(int id,Product product);

	public List<Product> getAllProducts();
	
	public void deleteProduct(int id);

	public Product getoneById(int id);
	
	public List<Product> getproductlike(String productlike);
	
	public List<Product> getLowStock();
	
	public int getStockInHand();
	
	public int getTotalproductcount();
	
	  public Page<Product> getAllproduct(Pageable paging);
	  
	  public Page<Product> findByProductNameContaining(String title,Pageable paging);
	  
	  public Page<List<Map<String, Object>>> getInventoryReport(Pageable paging);
	  
	  public Page<List<Map<String, Object>>> getInventoryReportTitle(String title,Pageable paging);
	  
	  public void updateProductQuantity(int id,String qty,String updatefrom);

	public void updatebatchQuantity(int id, String qty, String batch);
	
	public void updateProductQuantityBatchAdjust(int id,String qty);

}
