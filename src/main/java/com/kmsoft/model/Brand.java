package com.kmsoft.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="brand")
public class Brand {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int brandId;
	
	@Column(name="brandName")
	String brandName;

	public int getBrandId() {
		return brandId;
	}

	public void setBrandId(int brandId) {
		this.brandId = brandId;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = "#"+brandName;
	}

	public Brand() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
