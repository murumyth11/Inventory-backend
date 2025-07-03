package com.kmsoft.model;

import jakarta.persistence.*;

@Entity
@Table(name="SalesReturnProduct")
public class SalesReturnProduct {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int srpId;
	
	@ManyToOne
	@JoinColumn(name="productFk",referencedColumnName = "productId")
	Product name;
	
	@Column(name="quantity",columnDefinition="DECIMAL(10,2)")
	float quantity;
	
	
	@Column(name="rate",columnDefinition="DECIMAL(10,2)")
	float rate;
	
	@Column(name="amount",columnDefinition="DECIMAL(10,2)")
	float amount;

	@Column(name="code")
	String code;
	
	@Column(name="batchid")
	String batchid;
	
	@Column(name="batch")
	String batch;
	
	@Column(name="unit")
	String unit;

	
	
	public String getBatchid() {
		return batchid;
	}

	public void setBatchid(String batchid) {
		this.batchid = batchid;
	}

	public int getSrpId() {
		return srpId;
	}

	public void setSrpId(int srpId) {
		this.srpId = srpId;
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

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	
	public SalesReturnProduct(int srpId, Product name, float quantity, float rate, float amount, String code,
			String batchid, String batch, String unit) {
		super();
		this.srpId = srpId;
		this.name = name;
		this.quantity = quantity;
		this.rate = rate;
		this.amount = amount;
		this.code = code;
		this.batchid = batchid;
		this.batch = batch;
		this.unit = unit;
	}

	public SalesReturnProduct() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
