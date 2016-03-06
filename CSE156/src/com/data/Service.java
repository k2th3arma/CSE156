package com.data;

public class Service extends Product{

	private String activationFee;
	private String annualFee;
	private String serviceCode;
	
	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	//Constructor
	public Service(String productCode, String productName, String activationFee, String annualFee) {
		super(productCode, productName);
		this.activationFee = activationFee;
		this.annualFee = annualFee;
	}
	
	//Setters and Getters
	public String getProductCode() {
		return productCode;
	}

	public String getProductName() {
		return productName;
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
