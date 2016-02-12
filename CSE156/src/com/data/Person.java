package com.data;

public class Person implements Invoice{
	private String personCode;
	private String lastName;
	private String firstName;
	private Address address;
	private String[] email;
	
	//Constructors
	public Person(String personCode, String lastName, String firstName, Address address, String[] email) {
		this.personCode = personCode;
		this.lastName = lastName;
		this.firstName = firstName;
		this.address = address;
		this.email = email;
	}
	public Person(){
		super();
	}
	
	//Setters and Getters
	public void setEmail(String[] email) {
		this.email = email;
	}
	
	public String[] getEmail(){
		return this.email;
	}

	public void setAddress(Address address) {
		this.address = address;		
	}
	
	public Address getAddress(){
		return this.address;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;		
	}
	
	public String getFirstName(){
		return this.firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;		
	}
	
	public String getLastName(){
		return this.lastName;
	}

	public void setPersonCode(String personCode) {
		this.personCode = personCode;		
	}
	
	public String getPersonCode(){
		return this.personCode;
	}
	
	//Other Methods...
	public Service getService() {
		return null;
	}
}
