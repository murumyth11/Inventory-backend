package com.kmsoft.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ProductValidators")
public class ProductValidators {
	@Id
	int pvId;

	public int getPvId() {
		return pvId;
	}

	public void setPvId(int pvId) {
		this.pvId = pvId;
	}

	@Column(name = "productName")
	boolean productName;

	@Column(name = "brand")
	boolean brand;

	@Column(name = "costPrice")
	boolean costPrice;

	@Column(name = "dimension")
	boolean dimension;

	@Column(name = "manufacture_part_number")
	boolean manufacturePartNumber;

	@Column(name = "manufacturer")
	boolean manufacturer;

	@Column(name = "primaryunit")
	boolean primaryUnit;

	@Column(name = "productKey")
	boolean productKey;

	@Column(name = "productQuantity")
	boolean productQuantity;

	@Column(name = "secondaryUnit")
	boolean secondaryUnit;

	@Column(name = "sellingPrice")
	boolean sellingPrice;

	@Column(name = "universalProductCode")
	boolean universalProductCode;

	@Column(name = "productgroup")
	boolean productgroup;
	
	@Column(name="batch")
	boolean batch;

	public boolean isBatch() {
		return batch;
	}

	public void setBatch(boolean batch) {
		this.batch = batch;
	}

	public boolean isProductName() {
		return productName;
	}

	public void setProductName(boolean productName) {
		this.productName = productName;
	}

	public boolean isBrand() {
		return brand;
	}

	public void setBrand(boolean brand) {
		this.brand = brand;
	}

	public boolean isCostPrice() {
		return costPrice;
	}

	public void setCostPrice(boolean costPrice) {
		this.costPrice = costPrice;
	}

	public boolean isDimension() {
		return dimension;
	}

	public void setDimension(boolean dimension) {
		this.dimension = dimension;
	}

	public boolean isManufacturePartNumber() {
		return manufacturePartNumber;
	}

	public void setManufacturePartNumber(boolean manufacturePartNumber) {
		this.manufacturePartNumber = manufacturePartNumber;
	}

	public boolean isManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(boolean manufacturer) {
		this.manufacturer = manufacturer;
	}

	public boolean isPrimaryUnit() {
		return primaryUnit;
	}

	public void setPrimaryUnit(boolean primaryUnit) {
		this.primaryUnit = primaryUnit;
	}

	public boolean isProductKey() {
		return productKey;
	}

	public void setProductKey(boolean productKey) {
		this.productKey = productKey;
	}

	public boolean isProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(boolean productQuantity) {
		this.productQuantity = productQuantity;
	}

	public boolean isSecondaryUnit() {
		return secondaryUnit;
	}

	public void setSecondaryUnit(boolean secondaryUnit) {
		this.secondaryUnit = secondaryUnit;
	}

	public boolean isSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(boolean sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public boolean isUniversalProductCode() {
		return universalProductCode;
	}

	public void setUniversalProductCode(boolean universalProductCode) {
		this.universalProductCode = universalProductCode;
	}

	public boolean isProductgroup() {
		return productgroup;
	}

	public void setProductgroup(boolean productgroup) {
		this.productgroup = productgroup;
	}

	

	public ProductValidators(int pvId, boolean productName, boolean brand, boolean costPrice, boolean dimension,
			boolean manufacturePartNumber, boolean manufacturer, boolean primaryUnit, boolean productKey,
			boolean productQuantity, boolean secondaryUnit, boolean sellingPrice, boolean universalProductCode,
			boolean productgroup, boolean batch) {
		super();
		this.pvId = pvId;
		this.productName = productName;
		this.brand = brand;
		this.costPrice = costPrice;
		this.dimension = dimension;
		this.manufacturePartNumber = manufacturePartNumber;
		this.manufacturer = manufacturer;
		this.primaryUnit = primaryUnit;
		this.productKey = productKey;
		this.productQuantity = productQuantity;
		this.secondaryUnit = secondaryUnit;
		this.sellingPrice = sellingPrice;
		this.universalProductCode = universalProductCode;
		this.productgroup = productgroup;
		this.batch = batch;
	}

	public ProductValidators() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
