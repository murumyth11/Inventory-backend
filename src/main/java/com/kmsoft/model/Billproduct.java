package com.kmsoft.model;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Billproduct")

public class Billproduct {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int billproductId;
	
	@ManyToOne
	@JoinColumn(name="productFk",referencedColumnName = "productId")
	Product name;
	
	

	@Column(name="quantity",columnDefinition="DECIMAL(10,2)")
	float quantity;
	
	@Column(name="convertedQuantity",columnDefinition="DECIMAL(10,2)")
	float convertedQuantity;
	
	@Column(name="unit")
	String unit;
	
	@Column(name="batch")
	String batch;
	
	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public float getConvertedQuantity() {
		return convertedQuantity;
	}

	public void setConvertedQuantity(float convertedQuantity) {
		this.convertedQuantity = convertedQuantity;
	}

	@Column(name="discount",columnDefinition="DECIMAL(10,2)")
	int discount;
	
	@Column(name="discountType")
	String discountType;
	
	public String getDiscountType() {
		return discountType;
	}

	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}

	public Product getName() {
		return name;
	}

	public void setName(Product name) {
		this.name = name;
	}

	@Column(name="rate",columnDefinition="DECIMAL(10,2)")
	BigDecimal rate;
	
	@Column(name="amount",columnDefinition="DECIMAL(10,2)")
	float amount;

	@Column(name="code")
	String code;
    
	
	@Column(name="batchid")
	int batchid;
	

	

	public int getBatchid() {
		return batchid;
	}

	public void setBatchid(int batchid) {
		this.batchid = batchid;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public float getQuantity() {
		return quantity;
	}

	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	
	public int getBillproductId() {
		return billproductId;
	}

	public void setBillproductId(int billproductId) {
		this.billproductId = billproductId;
	}

	

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	

	

	public Billproduct(int billproductId, Product name, float quantity, float convertedQuantity, String unit,
			String batch, int discount, String discountType, BigDecimal rate, float amount, String code, int batchid) {
		super();
		this.billproductId = billproductId;
		this.name = name;
		this.quantity = quantity;
		this.convertedQuantity = convertedQuantity;
		this.unit = unit;
		this.batch = batch;
		this.discount = discount;
		this.discountType = discountType;
		this.rate = rate;
		this.amount = amount;
		this.code = code;
		this.batchid = batchid;
	}

	public Billproduct() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
