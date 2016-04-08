package com.output;


	/*
	 * MWC program
	 * ---designed and built by Ronnie Gallagher and Jacob Reis
	 * Description: 
	 * 	The program reads data files and outputs the data collected into Json and XML formatted documents
	 */

	import java.util.List;
	import com.data.Customer;
	import com.data.Invoice;
	import com.data.Person;
	import com.data.Product;
	import com.fileReader.FileReader;
	import com.fileWriter.JsonWriter;
	import com.fileWriter.XMLWriter;
import com.mwc.ext.InvoiceData;

	public class DataTransfer {

		public static void main(String[] args) {
				
			// Create a FlatFileReader object
			FileReader fp = new FileReader();
	
			List<Person> personList = fp.readPersons();
			List<Invoice> invoiceList = fp.readInvoice();
				
			// Write Person ArrayList into a Json file
			JsonWriter jWriter = new JsonWriter();
			jWriter.jsonPerson(personList);
				
			// Write Person ArrayList into an XML file
			XMLWriter xmlWriter = new XMLWriter();
			xmlWriter.xmlPerson(personList);
			
			List<Customer> customerList = fp.readCustomer();
					
			// Write Person ArrayList into a Json file
			jWriter.jsonCustomer(customerList);
					
			// Write Person ArrayList into an XML file
			xmlWriter.xmlCustomer(customerList);
	
			List<Product> productList = fp.readProduct();
						
			// Write Person ArrayList into a Json file
			jWriter.jsonProduct(productList);
						
			// Write Person ArrayList into an XML file
			xmlWriter.xmlProduct(productList); 
			 
			InvoiceData.addServiceToInvoice("INV003", "3294","2015-12-11", "2016-23-12");
			}
		


}
