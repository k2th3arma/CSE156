package com.data;

public class Product {

	protected String productCode;
	protected String productName;
	
	
	//Constructors
	public Product(String productCode, String productName){
		this.productCode = productCode;
		this.productName = productName;
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

