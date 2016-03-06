package com.data;

public abstract class Product {

	protected String productCode;
	protected String productName;
	protected String productType;
	
	//Constructors
	public Product(String productCode, String productName){
		this.productCode = productCode;
		this.productName = productName;
	//	this.productType= productType;
	}
	
	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	//Getters and Setters 
	public String getProductCode() {
		return productCode;
	}


	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}

	
	
	//Other Methods...
}

