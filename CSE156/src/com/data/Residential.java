package com.data;

public class Residential extends Customer {

	// Constructors
	public Residential(String customerCode, String customerType, Person person, String customerName, Address address) {
		super(customerCode, customerType, person, customerName, address);

	}

	@Override
	public double getTax() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double compliaceFee() {
		// TODO Auto-generated method stub
		return 125;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return "(Residential)";
	}

	// Setters and Getters

	// Other Methods...
}
