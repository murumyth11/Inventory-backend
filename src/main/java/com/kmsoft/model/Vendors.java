package com.kmsoft.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="vendors",uniqueConstraints={@UniqueConstraint(columnNames={"vendorMobile"})})
public class Vendors {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int vendorId;

	@Column(name="vendorName")
	String vendorName;
	
	@Column(name="vendorGSTIN")
	String vendorGSTIN;
	
	@Column(name="vendorMobile",unique = true)
	String vendorMobile;

	@Column(name="vendorAddress")
	String vendorAddress;
	
	public int getVendorId() {
		return vendorId;
	}

	public void setVendorId(int vendorId) {
		this.vendorId = vendorId;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getVendorGSTIN() {
		return vendorGSTIN;
	}

	public void setVendorGSTIN(String vendorGSTIN) {
		this.vendorGSTIN = vendorGSTIN;
	}

	public String getVendorMobile() {
		return vendorMobile;
	}

	public void setVendorMobile(String vendorMobile) {
		this.vendorMobile = vendorMobile;
	}

	public String getVendorAddress() {
		return vendorAddress;
	}

	public void setVendorAddress(String vendorAddress) {
		this.vendorAddress = vendorAddress;
	}

	public Vendors(int vendorId, String vendorName, String vendorGSTIN, String vendorMobile, String vendorAddress) {
		super();
		this.vendorId = vendorId;
		this.vendorName = vendorName;
		this.vendorGSTIN = vendorGSTIN;
		this.vendorMobile = vendorMobile;
		this.vendorAddress = vendorAddress;
	}

	public Vendors() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
