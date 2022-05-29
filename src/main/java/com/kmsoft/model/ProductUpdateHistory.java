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
@Table(name="ProductUpdateHistory")
public class  ProductUpdateHistory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int updateHistoryId;
	
	
	@Column(name="updateDate")
	String updateDate;
	
	@Column(name="updateData")
	String updateData;
	
	@Column(name="updateQuantity")
	int updateQuantity;
	
	@Column(name="batch")
	String batch;
	
	@Column(name="updateBy")
	String updateBy;
	
	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	@Column(name="updatefrom")
	String updatefrom;
	
	@ManyToOne
	@JoinColumn(name="productFk",referencedColumnName = "productId")
	Product product;

	
	
	public int getUpdateQuantity() {
		return updateQuantity;
	}

	public void setUpdateQuantity(int updateQuantity) {
		this.updateQuantity = updateQuantity;
	}
    
	
	

	
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

	public ProductUpdateHistory(int updateHistoryId, String updateDate, String updateData, int updateQuantity,
			String updateBy, String updatefrom, Product product,String batch) {
		super();
		this.updateHistoryId = updateHistoryId;
		this.updateDate = updateDate;
		this.updateData = updateData;
		this.updateQuantity = updateQuantity;
		this.updateBy = updateBy;
		this.updatefrom = updatefrom;
		this.product = product;
		this.batch=batch;
	}

	public String getUpdatefrom() {
		return updatefrom;
	}

	public void setUpdatefrom(String updatefrom) {
		this.updatefrom = updatefrom;
	}
	
	

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public ProductUpdateHistory() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
