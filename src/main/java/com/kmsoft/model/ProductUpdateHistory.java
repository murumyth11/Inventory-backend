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
@Table(name="productUpdateHistory")
public class  ProductUpdateHistory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int updateHistoryId;
	
	
	@Column(name="updateDate")
	String updateDate;
	
	@Column(name="updateData")
	String updateData;
	
	@Column(name="updateQuantity")
	int updateQuantity;
	
	public int getUpdateQuantity() {
		return updateQuantity;
	}

	public void setUpdateQuantity(int updateQuantity) {
		this.updateQuantity = updateQuantity;
	}
    
	@Column(name="updateFrom")
	String updateFrom;
	
	public String getUpdateFrom() {
		return updateFrom;
	}

	public void setUpdateFrom(String updateFrom) {
		this.updateFrom = updateFrom;
	}

	@ManyToOne
	@JoinColumn(name="productFk",referencedColumnName = "productId")
	Product product;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getUpdateHistoryId() {
		return updateHistoryId;
	}

	public void setUpdateHistoryId(int updateHistoryId) {
		this.updateHistoryId = updateHistoryId;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateData() {
		return updateData;
	}

	public void setUpdateData(String updateData) {
		this.updateData = updateData;
	}
	
	
	

}
