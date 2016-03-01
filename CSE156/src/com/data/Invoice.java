package com.data;

public class Invoice {
	private String invoiceCode;
	private String customerCode;
	private String invoiceDate;
	private Person salesPerson;
	private String[] productData;
	
	public Invoice(String invoiceCode, String customerCode, String invoiceDate, Person salesPerson, String[] productData){
		this.invoiceCode = invoiceCode;
		this.customerCode = customerCode;
		this.invoiceDate = invoiceDate;
		this.salesPerson = salesPerson;
		this.productData = productData;
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

	public String[] getProductData() {
		return productData;
	}

	public void setProductData(String[] productData) {
		this.productData = productData;
	}
	
	
	
}
