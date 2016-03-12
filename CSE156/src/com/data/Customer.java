package com.data;

public abstract class Customer {
	private String customerCode;
	private String customerType;
	private Person person;
	private String customerName;
	private Address address;

	// Constructor
	public Customer(String customerCode, String customerType, Person person, String customerName, Address address) {
		this.customerCode = customerCode;
		this.customerType = customerType;
		this.person = person;
		this.customerName = customerName;
		this.address = address;
	}

	public Customer() {

	}

	// Setters & Getters
	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
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

	public abstract double getTax();

	public abstract String getType();

	public abstract double compliaceFee();

	// Other Methods...
}
