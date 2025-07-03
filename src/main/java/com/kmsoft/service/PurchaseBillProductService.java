package com.kmsoft.service;

import com.kmsoft.model.PurchaseBillProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface PurchaseBillProductService {

	public PurchaseBillProduct createpbp(PurchaseBillProduct billProduct);

	public List<PurchaseBillProduct> getpbpbyid(int id);

	public List<PurchaseBillProduct> getbatchcode(int id);

	public Page<PurchaseBillProduct> findAllBatchById(int id, Pageable paging);

	public Page<PurchaseBillProduct> findByBatchContaining(String title, int id, Pageable paging);

	public PurchaseBillProduct getavailableqty(int id);

	public Map<String, Number> gettotalstockinfo();
	
	public void updatAvailableQty(int id,String qty);

	public void updatRate(int pbpid1, String rate);

	public Page<List<Map<String, Object>>> getWarehouseProducts(String title, Pageable paging, int warehouseid);



}
