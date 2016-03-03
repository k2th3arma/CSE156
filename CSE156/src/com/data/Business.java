package com.data;

public class Business extends Customer{
	
	//Constructor
	public Business(String customerCode, String customerType, Person person, String customerName, Address address) {
		super(customerCode, customerType, person, customerName, address);

	}

	
	
	@Override
	public double getTax() {
		
		return .07;
	}

	@Override
	public double compliaceFee() {
		
		return 0;
	}



	@Override
	public String getType() {
		
		return "(Business)";
	}

	//Getters and Setters

	//Other Methods...
}
