package com.kmsoft.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class ProductGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int productGroupId;

	
@Column(name="productGroupName")
	String productGroupName;

	public int getProductGroupId() {
		return productGroupId;
	}

	public void setProductGroupId(int productGroupId) {
		this.productGroupId = productGroupId;
	}

	public String getProductGroupName() {
		return productGroupName;
	}

	public void setProductGroupName(String productGroupName) {
		this.productGroupName = productGroupName;
	}
	public ProductGroup(int productGroupId, String productGroupName) {
		super();
		this.productGroupId = productGroupId;
		this.productGroupName = productGroupName;
	}

	public ProductGroup() {
		super();
		// TODO Auto-generated constructor stub
	}

}
