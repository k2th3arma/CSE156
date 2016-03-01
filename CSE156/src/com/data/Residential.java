package com.data;

public class Residential extends Customer{


	//Constructors
	public Residential(String customerCode, Person person, String customerName, Address address) {
		super(customerCode, person, customerName, address);
		
	}

	@Override
	public double getTax() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double compliaceFee() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	//Setters and Getters
	

	//Other Methods...
}
