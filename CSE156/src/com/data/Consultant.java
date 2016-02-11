package com.data;

public class Consultant {
	private String productCode;
	private String productName;
	private Person person;
	private String serviceFee;
	
	//Constructors
	public Consultant(String productCode, String productName, Person person, String serviceFee) {
		this.productCode = productCode;
		this.productName = productName;
		this.person = person;
		this.serviceFee = serviceFee;
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
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getServiceFee(){
		return this. serviceFee;
	}
	
	public void setServiceFee(String serviceFee){
		this.serviceFee = serviceFee;
	}	

	//Other Methods...
}
