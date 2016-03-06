package com.data;

public class Equipment extends Product{

	private String fee;
	private String numProduct;
	private String prodcutType;
	
	public String getProdcutType() {
		return prodcutType;
	}

	public void setProdcutType(String prodcutType) {
		this.prodcutType = prodcutType;
	}

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
	
	public String getNumProduct() {
		return numProduct;
	}

	public void setNumProduct(String numProduct) {
		this.numProduct = numProduct;
	}
	//Other Methods...
}
