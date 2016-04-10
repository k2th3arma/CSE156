package com.fileWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import com.data.Customer;
import com.data.ObjectList;
import com.data.Person;
import com.data.Product;
import com.thoughtworks.xstream.XStream;

public class XMLWriter {
	
	//Method for creating the profile for each person in XML
	public void xmlPerson(List<Person> persons) {
		XStream  xstream = new XStream();
		
        File xmlOutput = new File("data/Persons.xml");
		
		PrintWriter xmlPrintWriter = null;
		try {
			xmlPrintWriter = new PrintWriter(xmlOutput);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		xmlPrintWriter.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n");
		
		xstream.alias("Person", Person.class); 
		
//		Person pers = null;
//		
//		Iterator<Person> itr = persons.iterator();
//		while(itr.hasNext()){
//			String personOutput = xstream.toXML(pers);
//			xmlPrintWriter.write(personOutput);
//		}
		
		for(Person aPerson : persons) {
			String personOutput = xstream.toXML(aPerson);
			xmlPrintWriter.write(personOutput);
		}
		xmlPrintWriter.close();	
	}
	
	//Method for creating the profile for each customer in XML 
	public void xmlCustomer(List<Customer> customerList) {
		XStream  xstream = new XStream();
		
        File xmlOutput = new File("data/Customers.xml");
		
		PrintWriter xmlPrintWriter = null;
		try {
			xmlPrintWriter = new PrintWriter(xmlOutput);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		xmlPrintWriter.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n");
		
		xstream.alias("Customer", Customer.class); 
		for(Customer aCustomer : customerList) {
			String customerOutput = xstream.toXML(aCustomer);
			xmlPrintWriter.write(customerOutput);
		}
		xmlPrintWriter.close();	
	}
	//Method for creating the profile for each product in XML
	public void xmlProduct(List<Product> productList) {
		XStream  xstream = new XStream();
		File xmlOutput = new File("data/Products.xml");
		 
		PrintWriter xmlPrintWriter = null;
		 
		try {
			xmlPrintWriter = new PrintWriter(xmlOutput);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		xmlPrintWriter.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n");
		 
		xstream.alias("Product", Product.class); 
		for(Product aProduct : productList) {
			String productOutput = xstream.toXML(aProduct);
			xmlPrintWriter.write(productOutput);
		}
		xmlPrintWriter.close();	
	}
}
