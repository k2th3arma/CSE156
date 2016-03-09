package com.data;

import org.joda.time.format.DateTimeFormatter;

public class Consultant extends Product{

	private Person person;
	private String serviceFee;
	private String ConsultantType;
	private String hours;
	
	
	public String getConsultantType() {
		return ConsultantType;
	}


	public void setConsultantType(String consultantType) {
		ConsultantType = consultantType;
	}


	//Constructors
	public Consultant(String productCode, String productName, Person person, String serviceFee) {
		super(productCode, productName);
		this.person = person;
		this.serviceFee = serviceFee;
	}

	
	//Getters and Setters
	public String getProductCode() {
		return productCode;
	}

	public String getProductName() {
		return productName;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public String getServiceFee(){
		return this. serviceFee;
	}
	
	public void setServiceFee(String serviceFee){
		this.serviceFee = serviceFee;
	}


	@Override
	public String getItems() {
		// TODO Auto-generated method stub
		return getProductName() + " " + getHours() + " hours at $" + getServiceFee();
	}


	public String getHours() {
		return hours;
	}


	public void setHours(String splitProducts) {
		this.hours = splitProducts;
	}


	@Override
	public long getDays() {
		// TODO Auto-generated method stub
		
	        return (Long) null;
	}


	@Override
	public long testDate() {
		// TODO Auto-generated method stub
		return 1;
	}


	@Override
	public String getTotalFees() {
		// TODO Auto-generated method stub
		return "150";
	}


	@Override
	public double getSubtotal() {
		// TODO Auto-generated method stub
		return 0;
	}	

	//Other Methods...
}
