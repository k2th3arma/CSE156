package com.fileReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import com.data.Address;
import com.data.Business;
import com.data.Consultant;
import com.data.Customer;
import com.data.Equipment;
import com.data.Invoice;
import com.data.DataCollection;
import com.data.Person;
import com.data.Product;
import com.data.Residential;
import com.data.Service;

public class FileReader {
	
	//File Reader for the person profile
	public ArrayList<Person> readPersons() {
		Scanner sc = null;
		ArrayList<Person> personList = null;
			try {
				sc = new Scanner(new File("data/Persons.dat"));
				sc.nextLine(); 
				
				 personList = new ArrayList<Person>();
				
				while(sc.hasNext()) {
					String line 			= sc.nextLine(); 
					String data[] 			= line.split(";");
					String email[] 			= null;
					String personCode 		= data[0];
					String name[] 			= data[1].split(",");
					String lastName 		= name[0];
					String firstName 		= name[1];
					String addressArray[]	= data[2].split(",");
					if(data.length == 4){
						email 	    		= data[3].split(",");
					}
					String street 			= addressArray[0];
					String city 			= addressArray[1];
					String state 			= addressArray[2];
					String zip 				= addressArray[3];
					String country			= addressArray[4];
					
					Address address = new Address(street, city, state, zip, country);
					
					Person person = new Person(personCode, lastName, firstName, address, email);

					personList.add(person);
				}
				sc.close();
				return personList;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				return null;
			}	
		}
	
	//File Reader for the customer profile
	public ArrayList<Customer> readCustomer() {
		Scanner sc = null;
				
		try {
				sc = new Scanner(new File("data/Customers.dat"));
				sc.nextLine(); 
					
				ArrayList<Customer> customerList = new ArrayList<Customer>();
					
				while(sc.hasNext()) {
					String line				 = sc.nextLine(); 
					String data[] 			 = line.split(";");
					String customerCode 	 = data[0];
					String customerType 	 = data[1];
					String personCode 		 = data[2];
					String customerName      = data[3];
					String addressArray[]	 = data[4].split(",");
					String street 			 = addressArray[0];
					String city 			 = addressArray[1];
					String state 			 = addressArray[2];
					String zip 				 = addressArray[3];
					String country			 = addressArray[4];
					Business business 		 = null;
					Residential residential  = null;
					Person person			 = null;
					
					Address address = new Address(street, city, state, zip, country);
					
					ArrayList<Person> persons = readPersons();
					
					for(Person pers: persons){
						if(pers.getPersonCode().equals(personCode)){
							person = pers;
						}
					}
					switch(customerType){
						case "B":
							
							business = new Business(customerCode, customerType, person, customerName, address);
							customerList.add(business);
							
							break;
						case "R":
							
							residential = new Residential(customerCode, customerType, person, customerName, address);
							customerList.add(residential);
							break;
					}
						
						
				}
				sc.close();
				return customerList;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				return null;
			}	
		}
	
	//File Reader for the product profile
	public ArrayList<Product> readProduct() {
		Scanner sc = null;
				
		try {
				sc = new Scanner(new File("data/Products.dat"));
				sc.nextLine(); 
					
				ArrayList<Product> productList = new ArrayList<Product>();
					
				while(sc.hasNext()) {
					String line					= sc.nextLine(); 
					String data[] 				= line.split(";");
					String fee 					= null;
					String activationFee 		= null;
					Equipment equipment 		= null;
					Service service			 	= null;
					Consultant consultation 	= null;
					Product product 			= null;
					
					switch(data[1]){
						case "E":
							String productCode 	= data[0];
							String productName 	= data[2];
							fee	   				= data[3];
							
							equipment = new Equipment(productCode, productName, fee);
							productList.add(equipment);
							
							break;
						case "S":
							 productCode 		= data[0];
							 productName 		= data[2];
							 activationFee   	= data[3];
							 String annualFee 	= data[4];
							 
							 service = new Service(productCode, productName, activationFee, annualFee);
							 productList.add(service);
							 
							 break;
						case "C":
							 productCode	    = data[0];
							 productName	    = data[2];
							 String personCode  = data[3];
							 String serviceFee  = data[4];
							 Person person      = null;
							 
							 ArrayList<Person> persons = readPersons();
						   	 
							 for(Person pers: persons){
								if(pers.getPersonCode().equals(personCode)){
									person = pers;
								}
							}
							 consultation = new Consultant(productCode, productName, person, serviceFee);
							 productList.add(consultation);
							 
							 break;
					}
					

				}
				sc.close();
				return productList;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				return null;
			}	
		}

	public ArrayList<Invoice> readInvoice() {
		Scanner sc = null;
		ArrayList<Invoice> invoiceList = null;
			try {
				sc = new Scanner(new File("data/Invoices.dat"));
				sc.nextLine(); 
				
				 invoiceList = new ArrayList<Invoice>();
				// Invoice invoice = null;
				 
				while(sc.hasNext()) {
					String line 			= sc.nextLine(); 
					String data[] 			= line.split(";");
					
					String invoiceCode 		= data[0];
					String customerCode		= data[1];
					String invoiceDate		= data[2];
					String salesPerson      = data[3];
					String productData[]    = data[4].split(",");
					String product;
					Person person = null;
					
					for(int i = 0; i < productData.length; ++i){
						product = productData[i];
					}
					ArrayList<Person> persons = readPersons();
				   	 
					for(Person pers: persons){
						if(pers.getPersonCode().equals(salesPerson)){
							person = pers;
						}
					}
					Invoice invoice = new Invoice(invoiceCode, customerCode, invoiceDate, person, productData);


					invoiceList.add(invoice);
				}
				sc.close();
				return invoiceList;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				return null;
			}	
		}
	

}
