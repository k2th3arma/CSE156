package com.data;

public class Residential {

	private String customerCode;
	private Person person;
	private String customerName;
	private Address address;
	
	//Constructors
	public Residential(String customerCode, Person person, String customerName, Address address) {
		this.customerCode = customerCode;
		this.person = person;
		this.customerName = customerName;
		this.address = address;
	}
	
	//Setters and Getters
	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	//Other Methods...
}
