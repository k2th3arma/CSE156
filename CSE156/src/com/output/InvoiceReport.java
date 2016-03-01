package com.output;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;



import com.data.Customer;
import com.data.Invoice;
import com.data.Person;
import com.data.Product;
import com.fileReader.FileReader;


public class InvoiceReport {
	private List<Person> persons;
	private List<Customer> customers;
	private List<Product> products;
	
	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}

	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public InvoiceReport(List<Person> persons, List<Customer> customers, List<Product> products){
		this.persons=persons;
		this.customers = customers;
		this.products=products;
		
	}
	

	public static void main(String[] args) {
		
		
		
		// Create a FlatFileReader object
		FileReader fp = new FileReader();
		
		List<Person> personList = fp.readPersons();
		
		List<Customer> customerList = fp.readCustomer();
		
		List<Product> productList = fp.readProduct();
		
		List<Invoice> invoiceList = fp.readInvoice();
		
		
		String fileName= "data/output.txt";
		try{
			PrintWriter outputStream= new PrintWriter(fileName);
	
			outputStream.println("INVOICE SUMMARY REPORT");
			outputStream.println("========================================");
			StringBuilder sb = new StringBuilder();
			
			sb.append(String.format("%-12s %-30s %-30s %-9s %9s %9s %9s\n", 
					"Invoice", "Customer", "Salesperson", "SubTotal", "Fees", "Taxes", "Total"));
			
			for(Invoice i : invoiceList) {
		//format their information
				Customer cust = null;
				//Customer per=null;
				for(Customer c : customerList) {
					if (c.getCustomerCode().equals(i.getCustomerCode())) {
						cust = c;
//						if(c.getPerson().equals(i.getSalesPerson())){
//							per=c;
//						}
					}
				
				}
			
				Person per = null;
			for(Person p : personList){
				if (p.getPersonCode().equals(i.getSalesPerson().getPersonCode())){
						per=p;
				}
				
					}
				sb.append(String.format("%-12s %-30s %-30s %-9s %9s %9s %9s\n",
					 i.getInvoiceCode(), cust.getCustomerName(), per.getName(), "null", "null", "null", "null")); //TODO: replace these
				
			}
	 

			
			outputStream.println(sb);
			outputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
//		for(int a=0; a < invoiceList.size(); a++){
//			
//			
 
		
		
		
	}
}
