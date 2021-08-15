package com.kmsoft.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ProductGroup")
public class ProductGroup {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int productGroupId;

	@Column(name = "productGroupName")
	String productGroupName;
	
	@Column(name="description")
	String description;
	
	@Column(name="unit")
	String unit;
	
	@Column(name="manufacturer")
	String manufacturer;
	
	@Column(name="brand")
	String brand;

	/*@OneToMany(mappedBy = "productgroup")
	List<Product> products =new ArrayList<>();

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}*/

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
