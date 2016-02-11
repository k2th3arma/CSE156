package com.data;

public class Address {
	private String street;
	private String city;
	private String state;
	private String zip;
	private String country;
	
	//Constructors
	public Address(String street, String city, String state, String zip, String country) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.country = country;
	}
	
	//Getters and Setters
	public void setCountry(String country){
		this.country = country;
	}
	
	public String getCountry(){
		return this.country;
	}

	public void setZip(String zip) {
		this.zip = zip;		
	}
	
	public String getZip(){
		return this.zip;
	}

	public void setState(String state) {
		this.state = state;		
	}
	
	public String getState(){
		return this.state;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	public String getCity(){
		return this.city;
	}

	public void setStreet(String street) {
		this.street = street;
	}
	
	public String getStreet(){
		return this.street;
	}

	//Other Methods...
}
