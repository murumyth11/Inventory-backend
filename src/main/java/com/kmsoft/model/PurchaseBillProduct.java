package com.kmsoft.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="purchasebillproduct")
public class PurchaseBillProduct {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int pbpId;
	
	@ManyToOne
	@JoinColumn(name="productFk",referencedColumnName = "productId")
	Product name;
	
	@Column(name="quantity",columnDefinition="DECIMAL(10,2)")
	float quantity;
	
	@Column(name="availablequantity")
	float availablequantity;
	
	@Column(name="rate",columnDefinition="DECIMAL(10,2)")
	float rate;
	
	@Column(name="amount",columnDefinition="DECIMAL(10,2)")
	float amount;

	@Column(name="code")
	String code;
	
	@Column(name="batch")
	String batch;
	
	@Column(name="unit")
	String unit;
	
	

	public float getAvailablequantity() {
		return availablequantity;
	}

	public void setAvailablequantity(float availablequantity) {
		this.availablequantity = availablequantity;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public int getPbpId() {
		return pbpId;
	}

	public void setPbpId(int pbpId) {
		this.pbpId = pbpId;
	}

	public Product getName() {
		return name;
	}

	public void setName(Product name) {
		this.name = name;
	}

	public float getQuantity() {
		return quantity;
	}

	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	
	

	public PurchaseBillProduct(int pbpId, Product name, float quantity, float rate, float amount, String code,
			String batch, String unit,float availablequantity) {
		super();
		this.pbpId = pbpId;
		this.name = name;
		this.quantity = quantity;
		this.rate = rate;
		this.amount = amount;
		this.code = code;
		this.batch = batch;
		this.unit = unit;
		this.availablequantity=availablequantity;
	}

	public PurchaseBillProduct() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
