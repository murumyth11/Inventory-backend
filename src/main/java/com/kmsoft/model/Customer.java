package com.kmsoft.model;

import jakarta.persistence.*;

@Entity
@Table(name="customer",uniqueConstraints={@UniqueConstraint(columnNames={"customerPhone"})})
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int customerId;
	
	@Column(name="customerName")
	String customerName;
	
	@Column(name="customerPhone",unique = true)
	String customerPhone;
	
	@Column(name="customerEmail")
	String customerEmail;
	
	@Column(name="customerAddress")
	String customerAddress;
	
	@Column(name="isAlive" ,columnDefinition = "integer default '1'")
	int isalive;

	
	public int getIsalive() {
		return isalive;
	}

	public void setIsalive(int isalive) {
		this.isalive = isalive;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public Customer(int customerId, String customerName, String customerPhone, String customerEmail,
			String customerAddress, int isalive) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerPhone = customerPhone;
		this.customerEmail = customerEmail;
		this.customerAddress = customerAddress;
		this.isalive = isalive;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
