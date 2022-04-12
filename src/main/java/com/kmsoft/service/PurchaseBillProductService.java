package com.kmsoft.service;

import java.util.List;

import com.kmsoft.model.PurchaseBillProduct;

public interface PurchaseBillProductService {

	public PurchaseBillProduct createpbp(PurchaseBillProduct billProduct);

	public List<PurchaseBillProduct> getpbpbyid(int id);

	public List<PurchaseBillProduct> getbatchcode(int id);

}
