package com.kmsoft.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "ProductGroup")
@JsonIgnoreProperties({ "product" })
public class ProductGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int productGroupId;

	@Column(name = "productGroupName")
	String productGroupName;

	@Column(name = "description")
	String description;

	@Column(name = "unit")
	String unit;

	@Column(name = "manufacturer")
	String manufacturer;

	@Column(name = "brand")
	String brand;
	
	@Column(name="isalivegroup",columnDefinition = "integer default '1'")
	int isalivegroup;

	public int getIsalivegroup() {
		return isalivegroup;
	}

	public void setIsalivegroup(int isalivegroup) {
		this.isalivegroup = isalivegroup;
	}

	@OneToMany(mappedBy = "productgroup", cascade = { CascadeType.ALL })
	List<Product> product = new ArrayList<Product>();

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}
	
	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

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

	public ProductGroup() {
		super();
		// TODO Auto-generated constructor stub
	}

}
