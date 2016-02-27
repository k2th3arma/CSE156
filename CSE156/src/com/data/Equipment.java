package com.data;

public class Equipment extends Product{

	private String fee;
	
	//Constructors
	public Equipment(String productCode, String productName, String fee) {
		super(productCode, productName);
		this.fee = fee;
	}
	
	//Getters and Setters
	public String getProductCode() {
		return productCode;
	}

	public String getProductName() {
		return productName;
	}

	public String getFee() {
		return fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}

	//Other Methods...
}
