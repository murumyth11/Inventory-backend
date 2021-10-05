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
	
	

	@Column(name="quantity")
	int quantity;
	
	@Column(name="unit")
	String unit;
	
	@Column(name="discount")
	int discount;
	
	public Product getName() {
		return name;
	}

	public void setName(Product name) {
		this.name = name;
	}

	@Column(name="rate")
	int rate;
	
	@Column(name="amount")
	int amount;

	

	

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
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
