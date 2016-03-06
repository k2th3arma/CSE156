package com.data;
import java.io.PrintWriter;
import java.util.List;
import java.io.*;

public class Invoice {
	private String invoiceCode;
	private String customerCode;
	private String invoiceDate;
	private Person salesPerson;
	private List<Product> productData;
	
	public Invoice(String invoiceCode, String customerCode, String invoiceDate, Person salesPerson, List<Product> productData){
		this.invoiceCode = invoiceCode;
		this.customerCode = customerCode;
		this.invoiceDate = invoiceDate;
		this.salesPerson = salesPerson;
		this.productData= productData;
	}

	public String getInvoiceCode() {
		return invoiceCode;
	}

	public void setInvoiceCode(String invoiceCode) {
		this.invoiceCode = invoiceCode;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getInvoiceDate() {
		return invoiceDate;
	}

	public void setInvoiceData(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public Person getSalesPerson() {
		return salesPerson;
	}

	public void setSalesPerson(Person salesPerson) {
		this.salesPerson = salesPerson;
	}

	public List<Product> getProductData() {
		return productData;
	}

	public void setProductData(List<Product> productData) {
		this.productData = productData;
	}

//	public Object getProductCode() {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	
		
		
	
	
}
