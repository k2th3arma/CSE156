package com.fileReader;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.data.Address;
import com.data.Business;
import com.data.Consultant;
import com.data.Customer;
import com.data.Equipment;
import com.data.Invoice;
import com.data.DataCollection;
import com.data.Person;
import com.data.PersonList;
import com.data.Product;
import com.data.Residential;
import com.data.Service;



//import edu.unl.cse.sql.DatabaseInfo;

public class FileReader {
	
	//File Reader for the person profile
	public ArrayList<Person> readPersons() {

		//ArrayList<Person> personList = null;
		ArrayList<Person> p = null;
		
		String query = "select * from person join Email on person.PersonCode=Email.PersonCode join Address on person.PersonCode=Address.PersonCode";
		Connection conn = DatabaseInfo.getConnection();
		
		try
		{
			//personList = new ArrayList<Person>();
			PreparedStatement ps = conn.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			rs.next();

			while(rs.next()){
			Address address = new Address(rs.getString("street"),rs.getString("city"),rs.getString("state"),rs.getString("zip"),rs.getString("country"));
			
			String email[] 	= null;
			if(rs.getString("email") != null){
				email = rs.getString("email").split(",");
			}

			Person a = new Person(rs.getString("personCode"),rs.getString("FirstName"),rs.getString("LastName"),address, email);
			
			p.add(a);
			}
			conn.close();

		}

		catch (SQLException e)
		{
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return p;
	}

	//File Reader for the customer profile
	public ArrayList<Customer> readCustomer() {

		ArrayList<Customer> customerList = null;
		Business business 		 = null;
		Residential residential  = null;
		Person person			 = null;
		
		String query = "select * from customer join person on customer.PersonCode=person.PersonCode join Address on customer.customerCode=Address.customerCode";
		Connection conn = DatabaseInfo.getConnection();
		
		try
		{
			customerList = new ArrayList<Customer>();
			PreparedStatement ps = conn.prepareStatement(query);

			ResultSet rs = ps.executeQuery();
			rs.next();

			while(rs.next()){
			Address address = new Address(rs.getString("street"),rs.getString("city"),rs.getString("state"),rs.getString("zip"),rs.getString("country"));
			
			ArrayList<Person> persons = readPersons();
			//PersonList persons = readPersons();

			for(Person pers: persons){
			if(pers.getPersonCode().equals(rs.getString("PersonCode"))){
				person = pers;
			}
		}
		switch(rs.getString("CustomerType")){
			case "B":
				
				business = new Business(rs.getString("CustomerCode"), rs.getString("CustomerType"), person, rs.getString("CustomerContact"), address);
				
				customerList.add(business);
				
				break;
			case "R":
				
				residential = new Residential(rs.getString("CustomerCode"), rs.getString("CustomerType"), person, rs.getString("CustomerContact"), address);
				customerList.add(residential);
				break;
		}
			
			}
			
			conn.close();

			}

		catch (SQLException e)
		{
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return customerList;
	}

	
	//File Reader for the product profile
	public ArrayList<Product> readProduct() {
		
		ArrayList<Product> productList = null;
		Equipment equipment 		= null;
		Service service			 	= null;
		Consultant consultation 	= null;
		Person person 				= null;
		
		String query = "select * from products";
		Connection conn = DatabaseInfo.getConnection();
		
		try
		{
			productList = new ArrayList<Product>();
			PreparedStatement ps = conn.prepareStatement(query);

			ResultSet rs = ps.executeQuery();
			rs.next();

			while(rs.next()){
				
			switch(rs.getString("ProductType")){
			case "E":
				

				equipment = new Equipment(rs.getString("ProductCode"), rs.getString("ProductName"), rs.getString("ProductUnitPrice"));
				equipment.setProductType("E");
				productList.add(equipment);
				
				break;
			case "S":
 
				 service = new Service(rs.getString("ProductCode"), rs.getString("ProductName"), rs.getString("ProductSetUp"), rs.getString("ProductUnitPrice"));
				 service.setProductType("S");
				 productList.add(service);
				 
				 break;
			case "C":
 
				 ArrayList<Person> persons = readPersons();
			   	 
				 for(Person pers: persons){
					if(pers.getPersonCode().equals(rs.getString("personCode"))){
						person = pers;
					}
				}
				 consultation = new Consultant(rs.getString("ProductCode"), rs.getString("ProductName"), person, rs.getString("ProductUnitPrice"));
				 consultation.setProductType("C");
				 productList.add(consultation); 
				 break;
			
			}
			}
			conn.close();
			

		}

		catch (SQLException e)
		{
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return productList;
				
		}

	public ArrayList<Invoice> readInvoice() {

		ArrayList<Invoice> invoiceList = null;
		Equipment equipment 		= null;
		Service service			 	= null;
		Consultant consultation 	= null;
		Person person 				= null;
		
		String query = "select * from invoice join InvoiceProducts on invoice.InvoiceNum=InvoiceProducts.InvoiceNum";
		Connection conn = DatabaseInfo.getConnection();
		
		try
		{
			invoiceList = new ArrayList<Invoice>();
			PreparedStatement ps = conn.prepareStatement(query);

			ResultSet rs = ps.executeQuery();
			rs.next();

			while(rs.next()){
				
			//Empty array list 
			 ArrayList<Product> invoiceProduct= new ArrayList<Product>();
			

				ArrayList<Product> productList = readProduct();
				
				for(Product prod : productList){
					if (prod.getProductCode().equals(rs.getString("ProductCode"))){
					
						if (prod.getProductType().equals("E")){
						Equipment e  = (Equipment) prod;
						e.setNumProduct(rs.getString("ProductAmount"));
						
						invoiceProduct.add(e);

					}
					else if (prod.getProductType().equals("S")){
							
						Service s= (Service) prod;
						s.setStartDate(rs.getString("StartTime"));
						s.setEndDate(rs.getString("EndTime"));
						invoiceProduct.add(s);

					}	
					else if (prod.getProductType().equals("C")){
						Consultant c =(Consultant) prod;
						c.setHours(rs.getString("ProductAmount"));
						invoiceProduct.add(c);

				}

				}
			 }
			 
				
			ArrayList<Person> persons = readPersons();
		   	 
			for(Person pers: persons){
				if(pers.getPersonCode().equals(rs.getString("InvoiceRepCode"))){
					person = pers;
				}
			}
			Invoice invoice = new Invoice(rs.getString("InvoiceNum"),rs.getString("InvoiceCustomer"), rs.getString("invoiceDate"), person, invoiceProduct);
		
			invoiceList.add(invoice);
		
		}
			
			conn.close();
			
	}

		catch (SQLException e)
		{
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		return invoiceList;
	
		}
	
	
}
