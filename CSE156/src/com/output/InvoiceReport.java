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
		
		List<Product> invoiceProduct = fp.readProduct();
		
		String fileName= "data/output.txt";
		try{
			PrintWriter outputStream= new PrintWriter(fileName);
	
			outputStream.println("INVOICE SUMMARY REPORT");
			outputStream.println("========================================");
			StringBuilder sb = new StringBuilder();
			
			sb.append(String.format("%-12s %-30s %-30s %-9s %9s %9s %9s\n", 
					"Invoice", "Customer", "Salesperson", "SubTotal", "Fees", "Taxes", "Total"));
	//invoice number 
			for(Invoice i : invoiceList) {
		//To retrive the customer infor
				
				Customer cust = null;
				for(Customer c : customerList) {
					if (c.getCustomerCode().equals(i.getCustomerCode())) {
						cust = c;
					}
				}
		//Find the sales persons 	
				Person per = null;
			for(Person p : personList){
				if (p.getPersonCode().equals(i.getSalesPerson().getPersonCode())){
						per=p;
				}
					}
			
			
				sb.append(String.format("%-10s %-30s %-30s %-9s %9s %9s %9s\n",
					 i.getInvoiceCode(), cust.getCustomerName(), per.getName(), "Null", "null", "null", "null")); //TODO: replace these
				
			
			}

			outputStream.println(sb);
			
			outputStream.println("================================");
			outputStream.println("Invoice Detail Report");
			outputStream.println("================================");
		
			//second	
		
			
			

			for(Invoice inv : invoiceList) {
				StringBuilder nb = new StringBuilder();
			
			nb.append(String.format("%-10s %-50s %-9s %9s %9s %9s\n", 
			"Code", "Item", "SubTotal", "Taxes", "Fees", "Total"));
				Customer cust = null;
				//Customer per=null;
				for(Customer c : customerList) {
					if (c.getCustomerCode().equals(inv.getCustomerCode())) {
						cust = c;
					}
				}
				Person aPerson = null;
				for(Person p : personList){
					if (p.getPersonCode().equals(inv.getSalesPerson().getPersonCode())){
							aPerson=p;
					}
				}
//				Product pro =null;
//				for(Product pd : productList){
//					if (pd.getProductCode().equals(inv.getProductData())){
//						pro=pd;
//						//break;
//					}
//				}
//				Product ped =null;
//				for(Product pd : inv.getProductData()){
//					ped=pd;
				
				outputStream.println("");
				outputStream.println("");
				outputStream.println("----------------------------------");
				outputStream.println("Invoice: " + inv.getInvoiceCode());
				outputStream.println(inv.getInvoiceDate());
				outputStream.println("----------------------------------");
				outputStream.println("Salesperson: " + aPerson.getName());
				outputStream.println("Customer: ");
				outputStream.println("           " + cust.getCustomerName() + " (" + cust.getCustomerCode() + ")");
				outputStream.println("           " + cust.getType());
				outputStream.println("           " + cust.getPerson().getName());
				outputStream.println("           " + cust.getAddress().getStreet());
				outputStream.println("           " + cust.getAddress().getCity() + "," + cust.getAddress().getState() + " " + cust.getAddress().getZip() + " " + cust.getAddress().getCountry());
				outputStream.println("------------------------------------");
			
				
				
			//for(Product i : invoiceProduct) {
		//double cus=;
//			for(Invoice id : invoiceList){
				for(Customer c : customerList) {
					if (c.getCustomerType().equals('B')) {
						//cus=.07;
						cust = c;
					}
				
				}
				int eq=0;
				Product ped =null;
				for(Product pd : inv.getProductData()){
				//	eq=pd.getTax();
					ped=pd;
				for(int i=0; i < ped.getSubtotal(); i++ ){
					eq+=ped.getSubtotal();
					break;
				}
					nb.append(String.format("%-10s %-50s $%-9.2f $%-9.2f $%9s %9s\n",
							ped.getProductCode(), ped.getItems(), ped.getSubtotal(), (ped.getTax() * ped.getSubtotal()), ped.getTotalFees(), "null"));
				}
				outputStream.println(nb);
				outputStream.println("                                                              =====================================");
				outputStream.println("SUB-TOTALS                                                    $"  + eq);
				outputStream.println("COMPLIANCE FEE                                                $");
				outputStream.println("FINAL TOTAL                                                   $ ");
			}
			outputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	
	}
}
