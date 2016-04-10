package com.fileWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import com.data.ObjectList;
import com.data.Customer;
import com.data.Person;
import com.data.Product;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonWriter {
	
	//Method for creating the profile for each person in Json
	public void jsonPerson(List<Person> persons) {
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		File jsonOutput = new File("data/Persons.json");
		
		PrintWriter jsonPrintWriter = null;
		
		try {
			jsonPrintWriter = new PrintWriter(jsonOutput);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

//		Person pers = null;
		
//		Iterator<Person> itr = persons.iterator();
//		while(itr.hasNext()){
//			String personOutput = gson.toJson(pers); 
//			jsonPrintWriter.write(personOutput + "\n");
//		}

		for(Person aPerson : persons) {
			String personOutput = gson.toJson(aPerson); 
			jsonPrintWriter.write(personOutput + "\n");
		}
		
		jsonPrintWriter.close();
	}
	
	//Method for creating the profile for each customer in Json
	public void jsonCustomer(List<Customer> customer) {
		
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		File jsonOutput = new File("data/Customers.json");
		
		PrintWriter jsonPrintWriter = null;
		
		try {
			jsonPrintWriter = new PrintWriter(jsonOutput);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		
		for(Customer aCustomer : customer) {
			String customerOutput = gson.toJson(aCustomer); 
			jsonPrintWriter.write(customerOutput + "\n");
		}
		
		jsonPrintWriter.close();
	}
	
	//Method for creating the profile for each product in Json
	public void jsonProduct(List<Product> product) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		File jsonOutput = new File("data/Products.json");
			
		PrintWriter jsonPrintWriter = null;
			
		try {
			jsonPrintWriter = new PrintWriter(jsonOutput);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 
		for(Product aProduct : product) {
			String productOutput = gson.toJson(aProduct); 
			jsonPrintWriter.write(productOutput + "\n");
		}
		jsonPrintWriter.close();
	}
}

