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
@Table(name = "Product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int productId;
	
	@Column(name="productKey")
	String productKey;
	
	@Column(name = "productName")
	String productName;

	@Column(name = "productQuantity")
	int productQuantity;

	@Column(name = "productPrice")
	BigDecimal productPrice;
	
	@Column(name="productType")
	String productType;
	
	

	@ManyToOne
	@JoinColumn(name="productGroupFk",referencedColumnName = "productGroupId")
	ProductGroup productgroup;

	public ProductGroup getProductgroup() {
		return productgroup;
	}

	public void setProductgroup(ProductGroup productgroup) {
		this.productgroup = productgroup;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductKey() {
		return productKey;
	}

	public void setProductKey(String productKey) {
		this.productKey = productKey;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public BigDecimal getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(BigDecimal productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public Product(int productId, String productKey, String productName, int productQuantity, BigDecimal productPrice,
			String productType) {
		super();
		this.productId = productId;
		this.productKey = productKey;
		this.productName = productName;
		this.productQuantity = productQuantity;
		this.productPrice = productPrice;
		this.productType = productType;
	}
	
	
	

	
}
