package com.kmsoft.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Min;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers.DateDeserializer;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

@Entity
@Table(name = "Product")
@JsonIgnoreProperties({ "productUpdateHistory","billproduct","purchasebillproduct" })

public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int productId;

	@Column(name = "productKey")
	String productKey;

	@Column(name = "productName")
	String productName;

	
	
	@Column(name = "productQuantity",columnDefinition="DECIMAL(10,2)")
	
	float productQuantity;
	
	@Column(name="weight")
	int weight;
	
	@Column(name="entryDate")
//	@Temporal(TemporalType.TIMESTAMP)
//  @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss" ,timezone = "Asia/Kolkata")
    private String createDate;
	
	@OneToMany(mappedBy="name", cascade = { CascadeType.ALL })
		public List<Billproduct> billproduct=new ArrayList<Billproduct>();
	
	@OneToMany(mappedBy="name", cascade = { CascadeType.ALL })
	public List<PurchaseBillProduct> purchasebillproduct=new ArrayList<PurchaseBillProduct>();
		
    
	
	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	@Column(name="dimension")
	String dimension;

	public String getDimension() {
		return dimension;
	}

	public void setDimension(String dimension) {
		this.dimension = dimension;
	}

	@Column(name="primaryunit")
	
	String primaryUnit;
	
	@Column(name="secondaryunit")
	
	String secondaryUnit;
	
	@Column(name="unitconversion")
	
	int unitConversion;
	
	@Column(name="batch")
	String batch;
	
	
	@Column(name="isaliveproduct",columnDefinition = "integer default '1'")
	int isAliveProduct;
	
	@JsonDeserialize(using = DateDeserializer.class)
	@JsonSerialize(using = DateSerializer.class)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="manufacturedate" ,columnDefinition="DATETIME")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	Date manufacturedate;
	
	
	@JsonDeserialize(using = DateDeserializer.class)
	@JsonSerialize(using = DateSerializer.class)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="expirydate" ,columnDefinition="DATETIME")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	Date expirydate;
	
	

	
	
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

	public List<PurchaseBillProduct> getPurchasebillproduct() {
		return purchasebillproduct;
	}

	public void setPurchasebillproduct(List<PurchaseBillProduct> purchasebillproduct) {
		this.purchasebillproduct = purchasebillproduct;
	}

	

	public int getIsAliveProduct() {
		return isAliveProduct;
	}

	public void setIsAliveProduct(int isAliveProduct) {
		this.isAliveProduct = isAliveProduct;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public List<Billproduct> getBillproduct() {
		return billproduct;
	}

	public void setBillproduct(List<Billproduct> billproduct) {
		this.billproduct = billproduct;
	}

	public String getPrimaryUnit() {
		return primaryUnit;
	}

	public void setPrimaryUnit(String primaryUnit) {
		this.primaryUnit = primaryUnit;
	}

	public String getSecondaryUnit() {
		return secondaryUnit;
	}

	public void setSecondaryUnit(String secondaryUnit) {
		this.secondaryUnit = secondaryUnit;
	}

	public int getUnitConversion() {
		return unitConversion;
	}

	public void setUnitConversion(int unitConversion) {
		this.unitConversion = unitConversion;
	}

	@Column(name = "costPrice")
	BigDecimal costPrice;
	
	@Column(name="sellingPrice")
    BigDecimal sellingPrice;
	
	
	
	@Column(name="manufacturer")
	String manufacturer;
	
	@Column(name="brand")
	String brand;
	
	@Column(name="manufacturePartNumber")
	String manufacturePartNumber;
	
	@Column(name="universalProductCode")
	String universalProductCode;
	
	
	@Column(name = "productType")
	String productType;

	@ManyToOne
	@JoinColumn(name = "productGroupFk", referencedColumnName = "productGroupId")
	ProductGroup productgroup;
	
	@OneToMany(mappedBy="product",cascade = CascadeType.ALL,
        orphanRemoval = true)
	
		List<ProductUpdateHistory> productUpdateHistory=new ArrayList<ProductUpdateHistory>();

	
	

	public List<ProductUpdateHistory> getProductUpdateHistory() {
		return productUpdateHistory;
	}

	public void setProductUpdateHistory(List<ProductUpdateHistory> productUpdateHistory) {
		this.productUpdateHistory = productUpdateHistory;
	}

	public BigDecimal getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(BigDecimal costPrice) {
		this.costPrice = costPrice;
	}

	public BigDecimal getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(BigDecimal sellingPrice) {
		this.sellingPrice = sellingPrice;
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

	public String getManufacturePartNumber() {
		return manufacturePartNumber;
	}

	public void setManufacturePartNumber(String manufacturePartNumber) {
		this.manufacturePartNumber = manufacturePartNumber;
	}

	public String getUniversalProductCode() {
		return universalProductCode;
	}

	public void setUniversalProductCode(String universalProductCode) {
		this.universalProductCode = universalProductCode;
	}


	public ProductGroup getProductgroup() {
		return productgroup;
	}

	public void setProductgroup(ProductGroup productgroup) {
		this.productgroup = productgroup;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductKey() {
		return productKey;
	}

	public void setProductKey(String productKey) {
		this.productKey = productKey;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	



	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	

	public float getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(float productQuantity) {
		this.productQuantity = productQuantity;
	}

	public Product(int productId, String productKey, String productName, float productQuantity, int weight,
			String createDate, List<Billproduct> billproduct, List<PurchaseBillProduct> purchasebillproduct,
			String dimension, String primaryUnit, String secondaryUnit, int unitConversion, String batch,
			int isAliveProduct, Date manufacturedate, Date expirydate, BigDecimal costPrice,
			BigDecimal sellingPrice, String manufacturer, String brand, String manufacturePartNumber,
			String universalProductCode, String productType, ProductGroup productgroup,
			List<ProductUpdateHistory> productUpdateHistory) {
		super();
		this.productId = productId;
		this.productKey = productKey;
		this.productName = productName;
		this.productQuantity = productQuantity;
		this.weight = weight;
		this.createDate = createDate;
		this.billproduct = billproduct;
		this.purchasebillproduct = purchasebillproduct;
		this.dimension = dimension;
		this.primaryUnit = primaryUnit;
		this.secondaryUnit = secondaryUnit;
		this.unitConversion = unitConversion;
		this.batch = batch;
		this.isAliveProduct = isAliveProduct;
		this.manufacturedate = manufacturedate;
		this.expirydate = expirydate;
		this.costPrice = costPrice;
		this.sellingPrice = sellingPrice;
		this.manufacturer = manufacturer;
		this.brand = brand;
		this.manufacturePartNumber = manufacturePartNumber;
		this.universalProductCode = universalProductCode;
		this.productType = productType;
		this.productgroup = productgroup;
		this.productUpdateHistory = productUpdateHistory;
	}

	
	
	
}
