package com.mwc.ext;

import java.sql.*;

import com.fileReader.DatabaseInfo;

/* NOTE: Donot change the package name or any of the method signatures.
 *  
 * There are 14 methods in total, all of which need to be completed as a 
 * bare minimum as part of the assignment.You can add additional methods 
 * for testing if you feel.
 * 
 * It is also recommended that you write a separate program to read
 * from the .dat files and test these methods to insert data into your 
 * database.
 * 
 * Donot forget to change your reports generation classes to read from 
 * your database instead of the .dat files.
 */


/**
 * Class containing all methods interacting with the database.
 */
public class InvoiceData {
	
	/**Method that removes every person record from the database. 
	 */
	public static void removeAllPersons() {
}
	
	/**Method to add a person record to the database with the provided data. 
	 */
	public static void addPerson(String personCode, String firstName, String lastName, String street, String city, String state, String zip, String country) {
		Connection conn = DatabaseInfo.getConnection();
		PreparedStatement ps;
		ResultSet rs;
		
		try{
			String query = "SELECT * FROM person";
			String insert = "INSERT INTO person (PersonCode, PersonName, PersonAddress) VALUES(?,?,?)";
			
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			rs.next();
			
			ps = conn.prepareStatement(insert);
			
			ps.setString(1, personCode);
			ps.setString(2, firstName);
			ps.setString(3, street);
			
			ps.executeUpdate();
			rs.next();
			
			query = "SELECT * FROM Address";
			insert = "INSERT INTO Address (PersonCode, PersonName, PersonAddress) VALUES(?,?,?)";
			
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			rs.next();
			
			ps = conn.prepareStatement(insert);
			
			ps.setString(1, personCode);
			ps.setString(2, firstName);
			ps.setString(3, street);
			
			ps.executeUpdate();
			rs.next();
			
			conn.close();
		}
		catch(SQLException e){
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		
		
	}
	
	/**Method to add an email record to the database with the associated personCode. 
	 */
	public static void addEmail(String personCode, String email) {
		Connection conn = DatabaseInfo.getConnection();
		PreparedStatement ps;
		ResultSet rs;
		
		String query = "SELECT * FROM Email";
		String insert = "INSERT INTO Email (personCode, email) VALUES(?,?)";
		
		try{
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			rs.next();
			
			ps = conn.prepareStatement(insert);
			
			ps.setString(1, personCode);
			ps.setString(2, email);
			
			
			ps.executeUpdate();
			rs.next();
			
			conn.close();
		}
		catch(SQLException e){
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		}
	
	
	/**Method that removes every customer record from the database. 
	 */
	public static void removeAllCustomers() {
	}
	
	/**Method to add a customer record to the database with the provided data
	 */
	public static void addCustomer(String customerCode, String type, String primaryContactPersonCode, String name, 
			String street, String city, String state, String zip, String country) {
	}
	
	/**Removes all product records from the database. 
	 */
	public static void removeAllProducts() {
	}
	
	/**Adds an equipment record to the database with the provided data.
	 */
	public static void addEquipment(String productCode, String name, Double pricePerUnit) {
		
		Connection conn = DatabaseInfo.getConnection();
		PreparedStatement ps;
		ResultSet rs;
		
		String query = "SELECT * FROM products";
		String insert = "INSERT INTO products (ProductCode, ProductType, Productname, ProductUnitPrice) VALUES(?,'E',?,?)";
		
		try{
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			rs.next();
			
			ps = conn.prepareStatement(insert);
			
			ps.setString(1, productCode);
			//ps.setString(2, ProductType);
			ps.setString(2, name);
			ps.setString(3, String.valueOf(pricePerUnit));
			
			ps.executeUpdate();
			rs.next();
			
			conn.close();
		}
		catch(SQLException e){
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		}
		
	

	
	/**Adds a service record to the database with the provided data.
	 */
	public static void addService(String productCode, String name, double activationFee, double annualFee) {
		Connection conn = DatabaseInfo.getConnection();
		PreparedStatement ps;
		ResultSet rs;
		
		String query = "SELECT * FROM products";
		String insert = "INSERT INTO products (ProductCode, ProductType, Productname, ProductSetUp, ProductUnitPrice) VALUES(?,'S',?,?,?)";
		
		try{
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			rs.next();
			
			ps = conn.prepareStatement(insert);
			
			ps.setString(1, productCode);
			
			ps.setString(2, name);
			ps.setString(3, String.valueOf(activationFee));
			ps.setString(4, String.valueOf(annualFee));
			
			ps.executeUpdate();
			rs.next();
			
			conn.close();
		}
		catch(SQLException e){
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		}
	
	/**Adds an consultation record to the database with the provided data.
	 */
	public static void addConsultation(String productCode, String name, String consultantPersonCode, Double hourlyFee) {
		String query = "SELECT * FROM products";
		String insert = "INSERT INTO products (ProductCode, ProductType, Productname, ProductUnitPrice, personCode) VALUES(?,'C',?,?,?)";
		Connection conn = DatabaseInfo.getConnection();
		PreparedStatement ps;
		ResultSet rs;
		
		try{
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			rs.next();
			
			ps = conn.prepareStatement(insert);
			
			ps.setString(1, productCode);
			
			ps.setString(2, name);
			ps.setString(3, String.valueOf(hourlyFee));
			ps.setString(4, String.valueOf(consultantPersonCode));
			
			ps.executeUpdate();
			rs.next();
			
			conn.close();
		}
		catch(SQLException e){
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		}
	
	/**Removes all invoice records from the database. 
	 */
	public static void removeAllInvoices() {
	}
	
	/**Adds an invoice record to the database with the given data.  
	 */
	public static void addInvoice(String invoiceCode, String customerCode, String invoiceDate, String salesPersonCode) {
	}
	
	
	/**Adds a particular equipment (corresponding to productCode to an 
	 * invoice corresponding to the provided invoiceCode with the given
	 * number of units)
	 */
	public static void addEquipmentToInvoice(String invoiceCode, String productCode, int numUnits) {
		Connection conn = DatabaseInfo.getConnection();
		PreparedStatement ps;
		ResultSet rs;
		
		String query = "SELECT * FROM InvoiceProducts";
		String insert = "INSERT INTO InvoiceProducts (ProductCode, ProductAmount,InvoiceNum) VALUES(?,?,?)";
		//String make = "'CREATE TABLE `rgallagher`.`"+invoiceCode+"` (`InvoiceNum` VARCHAR(45) NOT NULL COMMENT '',`ProductCode` VARCHAR(45) NULL COMMENT '',`ProductAmount` VARCHAR(45) NULL COMMENT '',`TimeFrame` VARCHAR(45) NULL COMMENT '', PRIMARY KEY (`InvoiceNum`)  COMMENT '');'";
		try{
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			rs.next();
			
			ps = conn.prepareStatement(insert);
			
			ps.setString(1, productCode);
			ps.setString(2, String.valueOf(numUnits));
			ps.setString(3, invoiceCode);
			
			
			ps.executeUpdate();
			rs.next();
			
			conn.close();
		}
		catch(SQLException e){
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	/**Adds a particular service (corresponding to productCode to an 
	 * invoice corresponding to the provided invoiceCode with the given
	 * begin/end dates)
	 */
	public static void addServiceToInvoice(String invoiceCode, String productCode, String startDate, String endDate) {
		Connection conn = DatabaseInfo.getConnection();
		PreparedStatement ps;
		ResultSet rs;
		
		String query = "SELECT * FROM InvoiceProducts";
		String insert = "INSERT INTO InvoiceProducts (ProductCode, InvoiceNum,StartTime, EndTime) VALUES(?,?,?,?)";
		//String make = "'CREATE TABLE `rgallagher`.`"+invoiceCode+"` (`InvoiceNum` VARCHAR(45) NOT NULL COMMENT '',`ProductCode` VARCHAR(45) NULL COMMENT '',`ProductAmount` VARCHAR(45) NULL COMMENT '',`TimeFrame` VARCHAR(45) NULL COMMENT '', PRIMARY KEY (`InvoiceNum`)  COMMENT '');'";
		try{
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			rs.next();
			
			ps = conn.prepareStatement(insert);
			
			ps.setString(1, productCode);
			ps.setString(2, invoiceCode);
			ps.setString(3, startDate);
			ps.setString(4, endDate);
			
			ps.executeUpdate();
			rs.next();
			
			conn.close();
		}
		catch(SQLException e){
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	/**Adds a particular consultation (corresponding to productCode to an 
	 * invoice corresponding to the provided invoiceCode with the given
	 * number of billable hours.)
	 */
	public static void addConsultationToInvoice(String invoiceCode, String productCode, double numHours) {
		Connection conn = DatabaseInfo.getConnection();
		PreparedStatement ps;
		ResultSet rs;
		
		String query = "SELECT * FROM InvoiceProducts";
		String insert = "INSERT INTO InvoiceProducts (ProductCode, InvoiceNum,StartTime, EndTime) VALUES(?,?,?,?)";
		//String make = "'CREATE TABLE `rgallagher`.`"+invoiceCode+"` (`InvoiceNum` VARCHAR(45) NOT NULL COMMENT '',`ProductCode` VARCHAR(45) NULL COMMENT '',`ProductAmount` VARCHAR(45) NULL COMMENT '',`TimeFrame` VARCHAR(45) NULL COMMENT '', PRIMARY KEY (`InvoiceNum`)  COMMENT '');'";
		try{
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			rs.next();
			
			ps = conn.prepareStatement(insert);
			
			ps.setString(1, productCode);
			ps.setString(2, invoiceCode);
			ps.setString(3, startDate);
			ps.setString(4, endDate);
			
			ps.executeUpdate();
			rs.next();
			
			conn.close();
		}
		catch(SQLException e){
			System.out.println("SQLException: ");
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
		}
}