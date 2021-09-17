package com.kmsoft.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="billproduct")
public class Billproduct {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int billproductId;
	
	@OneToOne()
	@JoinColumn(name="fk")
	Product product;
	
	@Column(name="quantity")
	int quantity;
	
	@Column(name="discount")
	int discount;
	
	@Column(name="amount")
	int amount;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
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
	
	
	

}
