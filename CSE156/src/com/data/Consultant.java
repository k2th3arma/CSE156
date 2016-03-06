package com.data;

public class Consultant extends Product{

	private Person person;
	private String serviceFee;
	private String ConsultantType;
	
	public String getConsultantType() {
		return ConsultantType;
	}


	public void setConsultantType(String consultantType) {
		ConsultantType = consultantType;
	}


	//Constructors
	public Consultant(String productCode, String productName, Person person, String serviceFee) {
		super(productCode, productName);
		this.person = person;
		this.serviceFee = serviceFee;
	}

	
	//Getters and Setters
	public String getProductCode() {
		return productCode;
	}

	public String getProductName() {
		return productName;
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
