package com.kmsoft.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="billproduct")

public class Billproduct {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
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
	int rate;
	
	@Column(name="amount",columnDefinition="DECIMAL(10,2)")
	int amount;

	

	

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

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getBillproductId() {
		return billproductId;
	}

	public void setBillproductId(int billproductId) {
		this.billproductId = billproductId;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}
	
	

}
