package com.kmsoft.model;

import jakarta.persistence.*;

@Entity
public class Warehouse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int warehouseId;
	
	@Column(name="warehouseName")
	String warehouseName;
	
	@Column
	String warehouseNumber;
	
	@Column
	String warehousePhone;
	
	@Column
	String warehouseCity;
	
	@Column
	String warehouseState;
	
	@Column
	String warehouseZipcode;

	

	public int getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(int warehouseId) {
		this.warehouseId = warehouseId;
	}

	public String getWarehouseName() {
		return warehouseName;
	}

	public void setWarehouseName(String warehouseName) {
		this.warehouseName = warehouseName;
	}
	

	public String getWarehouseNumber() {
		return warehouseNumber;
	}

	public void setWarehouseNumber(String warehouseNumber) {
		this.warehouseNumber = warehouseNumber;
	}

	public String getWarehousePhone() {
		return warehousePhone;
	}

	public void setWarehousePhone(String warehousePhone) {
		this.warehousePhone = warehousePhone;
	}

	public String getWarehouseCity() {
		return warehouseCity;
	}

	public void setWarehouseCity(String warehouseCity) {
		this.warehouseCity = warehouseCity;
	}

	public String getWarehouseState() {
		return warehouseState;
	}

	public void setWarehouseState(String warehouseState) {
		this.warehouseState = warehouseState;
	}

	public String getWarehouseZipcode() {
		return warehouseZipcode;
	}

	public void setWarehouseZipcode(String warehouseZipcode) {
		this.warehouseZipcode = warehouseZipcode;
	}

	

	public Warehouse(int warehouseId, String warehouseName, String warehouseNumber, String warehousePhone,
			String warehouseCity, String warehouseState, String warehouseZipcode) {
		super();
		this.warehouseId = warehouseId;
		this.warehouseName = warehouseName;
		this.warehouseNumber = warehouseNumber;
		this.warehousePhone = warehousePhone;
		this.warehouseCity = warehouseCity;
		this.warehouseState = warehouseState;
		this.warehouseZipcode = warehouseZipcode;
	}

	public Warehouse() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}
