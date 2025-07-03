package com.kmsoft.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers.DateDeserializer;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name="PurchaseBillProduct")
public class PurchaseBillProduct {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int pbpId;
	
	@ManyToOne
	
	@JoinColumn(name="productFk",referencedColumnName = "productId")
	Product name;
	
	@Column(name="quantity",columnDefinition="DECIMAL(10,2)")
	float quantity;
	
	@Column(name="availablequantity")
	float availablequantity;
	
	@Column(name="rate",columnDefinition="DECIMAL(10,2)")
	float rate;
	
	@Column(name="costprice",columnDefinition = "DECIMAL(10,2)")
	float costprice;
	
	@Column(name="amount",columnDefinition="DECIMAL(10,2)")
	float amount;

	@Column(name="code")
	String code;
	
	@Column(name="batch")
	String batch;
	
	@Column(name="unit")
	String unit;
	
	
	@JsonDeserialize(using = DateDeserializer.class)
	@JsonSerialize(using = DateSerializer.class)
//	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="manufacturedate" ,columnDefinition="DATE")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	//@DateTimeFormat (pattern = "dd-MM-yyyy")
	public Date manufacturedate;
	
	@JsonDeserialize(using = DateDeserializer.class)
	@JsonSerialize(using = DateSerializer.class)
//	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="expirydate" ,columnDefinition="DATE")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	//@DateTimeFormat(pattern = "dd-MM-yyyy")
	public Date expirydate;
	
	@ManyToOne()
	@JoinColumn(name="warehouseFk",referencedColumnName = "warehouseId")
	Warehouse warehouse;
	
	

	public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	public float getAvailablequantity() {
		return availablequantity;
	}

	public void setAvailablequantity(float availablequantity) {
		this.availablequantity = availablequantity;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public int getPbpId() {
		return pbpId;
	}

	public void setPbpId(int pbpId) {
		this.pbpId = pbpId;
	}

	public Product getName() {
		return name;
	}

	public void setName(Product name) {
		this.name = name;
	}

	public float getQuantity() {
		return quantity;
	}

	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	
	public float getCostprice() {
		return costprice;
	}

	public void setCostprice(float costprice) {
		this.costprice = costprice;
	}

	public Date getManufacturedate() {
		return manufacturedate;
	}

	public void setManufacturedate(Date manufacturedate) {
		this.manufacturedate = manufacturedate;
	}

	public Date getExpirydate() {
		return expirydate;
	}

	public void setExpirydate(Date expirydate) {
		this.expirydate = expirydate;
	}

	

	public PurchaseBillProduct(int pbpId, Product name, float quantity, float availablequantity, float rate,
			float costprice, float amount, String code, String batch, String unit, Date manufacturedate,
			Date expirydate, Warehouse warehouse) {
		super();
		this.pbpId = pbpId;
		this.name = name;
		this.quantity = quantity;
		this.availablequantity = availablequantity;
		this.rate = rate;
		this.costprice = costprice;
		this.amount = amount;
		this.code = code;
		this.batch = batch;
		this.unit = unit;
		this.manufacturedate = manufacturedate;
		this.expirydate = expirydate;
		this.warehouse = warehouse;
	}

	public PurchaseBillProduct() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
