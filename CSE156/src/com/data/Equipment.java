package com.data;

public class Equipment {
	private String productCode;
	private String productName;
	private String fee;
	
	//Constructors
	public Equipment(String productCode, String productName, String fee) {
		this.productCode = productCode;
		this.productName = productName;
		this.fee = fee;
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
	public String getFee() {
		return fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}

	//Other Methods...
}
