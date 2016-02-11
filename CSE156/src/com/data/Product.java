package com.data;

public class Product {

	private Equipment equipment;
	private Service service;
	private Consultant consultant;
	
	//Constructors
	public Product(Equipment equipment) {
		this.equipment   = equipment;
	}
	
	public Product(Service service){
		this.service       = service;
	}
	
	public Product(Consultant consultant){
		this.consultant  = consultant;	
	}
	
	//Getters and Setters 
	public Equipment getEquipment(){
		return this.equipment;
	}
	
	public void setEquipment(Equipment equipment){
		this.equipment = equipment;
	}
	
	public Service getService(){
		return this.service;
	}
	
	public void setService(Service service){
		this.service = service;
	}
	
	public Consultant getConsultant(){
		return this.consultant;
	}
	
	public void setConsultant(Consultant consultant){
		this.consultant = consultant;
	}
	
	//Other Methods...
}

