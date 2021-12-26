package com.kmsoft.serviceImpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.kmsoft.model.Billproduct;
import com.kmsoft.model.Product;
import com.kmsoft.repository.ProductRepository;
import com.kmsoft.service.ProductService;

 
@Service
public class ProductServiceImp implements ProductService{
	
	@Autowired 
	ProductRepository productRepo;

   @Override
	public List<Product> getAllProducts() {
	
	   return productRepo.findAll();
	}

	
	public Product createProduct(Product product) {
		
		return productRepo.save(product);
	}


	public Product updateProduct(int id,Product product) {
		Product prod= productRepo.findById(id).get(0);
		prod.setProductId(product.getProductId());
		prod.setProductKey(product.getProductKey());
		prod.setProductName(product.getProductName());
		System.out.println(prod.getProductQuantity());
		System.out.println(product.getProductQuantity());
	
		prod.setProductQuantity(product.getProductQuantity()+prod.getProductQuantity());
		prod.setBrand(product.getBrand());
		prod.setManufacturer(product.getManufacturer());
		prod.setCostPrice(product.getCostPrice());
		prod.setSellingPrice(product.getSellingPrice());
		prod.setDimension(product.getDimension());
		prod.setManufacturePartNumber(product.getManufacturePartNumber());
		prod.setProductgroup(product.getProductgroup());
	   // prod.setprimaryUnit(product.getPrimaryUnit());
	    prod.setUniversalProductCode(product.getUniversalProductCode());
	    prod.setWeight(product.getWeight());
		
		return productRepo.saveAndFlush(prod);
	}


	@Override
	public void deleteProduct(int id) {
	
		 productRepo.deleteById(id);
	}


	@Override
	public List<Product> getoneById(int id) {
		// TODO Auto-generated method stub
		return productRepo.findById(id);
	}


	@Override
	public List<Product> getproductlike(String productlike) {
		// TODO Auto-generated method stub
		return productRepo.getProductLike(productlike);
	}


	@Override
	public List<Product> getLowStock() {
		// TODO Auto-generated method stub
		return productRepo.getLowStock();
	}


	@Override
	public int getStockInHand() {
		// TODO Auto-generated method stub
		return productRepo.getStockinHand();
	}


	@Override
	public int getTotalproductcount() {
		// TODO Auto-generated method stub
		return productRepo.getTotalproduct();
	}





	@Override
	public Page<Product> findByProductNameContaining(String title, Pageable paging) {
		// TODO Auto-generated method stub
		return productRepo.findByProductNameContaining(title, paging);
	}


	@Override
	public Page<List<Map<String, Object>>> getInventoryReport(Pageable paging) {
		// TODO Auto-generated method stub
		return productRepo.getInventoryReport(paging);
	}


	@Override
	public Page<List<Map<String, Object>>> getInventoryReportTitle(String title, Pageable paging) {
		// TODO Auto-generated method stub
		return productRepo.getInventoryReportTitle(title, paging);
	}


	@Override
	public Page<Product> getAllproduct(Pageable paging) {
		// TODO Auto-generated method stub
		return productRepo.findAll(paging);
	}


	@Override
	public void updateProductQuantity(int id, String qty) {
		// TODO Auto-generated method stub
		productRepo.updateProductQuantity(id, qty);
		
	}
 
	

}
