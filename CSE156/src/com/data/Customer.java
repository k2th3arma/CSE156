package com.data;

public class Customer {
	private Business business;
	private Residential residential;
	
	//Constructor
	public Customer(Business business) {
		this.business = business;
	}

	public Customer(Residential residential) {
		this.residential = residential;
	}

	//Setters & Getters
	public Business getBusiness() {
		return business;
	}

	public void setBusiness(Business business) {
		this.business = business;
	}

	public Residential getResidential() {
		return residential;
	}

	public void setResidential(Residential residential) {
		this.residential = residential;
	}
	
	//Other Methods...
}
