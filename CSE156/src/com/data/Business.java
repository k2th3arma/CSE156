package com.data;

public class Business extends Customer{
	
	//Constructor
	public Business(String customerCode, Person person, String customerName, Address address) {
		super(customerCode, person, customerName, address);

	}

	
	@Override
	public double getTax() {
		
		return .07;
	}

	@Override
	public double compliaceFee() {
		
		return 0;
	}

	//Getters and Setters

	//Other Methods...
}
