package com.data;

public class Service {
	private String productCode;
	private String productName;
	private String activationFee;
	private String annualFee;
	
	//Constructor
	public Service(String productCode, String productName, String activationFee, String annualFee) {
		this.productCode = productCode;
		this.productName = productName;
		this.activationFee = activationFee;
		this.annualFee = annualFee;
	}
	
	//Setters and Getters
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
	
	public String getActivationFee() {
		return activationFee;
	}

	public void setActivationFee(String activationFee) {
		this.activationFee = activationFee;
	}
	
	public String getAnnualFee(){
		return this. annualFee;
	}
	
	public void setAnnualFee(String annualFee){
		this.annualFee = annualFee;
	}
	
	//Other Methods...
}
