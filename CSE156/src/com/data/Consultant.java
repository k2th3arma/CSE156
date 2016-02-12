package com.data;

public class Consultant extends Person{
	private String productCode;
	private String productName;
	//private Person person;
	private String serviceFee;
	
	//Constructors
	public Consultant(String productCode, String productName, Person person, String serviceFee) {
		this.productCode = productCode;
		this.productName = productName;
		//person = Consultant(getPersonCode(), getLastName(), getFirstName(), getAddress(), getEmail());
		this.serviceFee = serviceFee;
	}
	public Consultant(String personCode, String lastName, String firstName, Address address, String[] email) {
		super(personCode, lastName, firstName, address, email);
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
	public com.data.Person Person() {
		return null;
	}

//	public void setPerson(Person person) {
//		this.person = person;
//	}

	public String getServiceFee(){
		return this. serviceFee;
	}
	
	public void setServiceFee(String serviceFee){
		this.serviceFee = serviceFee;
	}	

	//Other Methods...
}
