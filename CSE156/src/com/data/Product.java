package com.data;
import org.joda.time.format.DateTimeFormatter;
public abstract class Product {

	protected String productCode;
	protected String productName;
	protected String productType;
	

	//Constructors
	public Product(String productCode, String productName){
		this.productCode = productCode;
		this.productName = productName;
	//	this.productType= productType;
	}
	
	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	//Getters and Setters 
	public String getProductCode() {
		return productCode;
	}


	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}
	abstract public String getCustomerTax(); 
	abstract public double getTax();
	abstract public String getTotalFees();
	abstract public double getSubtotal();
	 abstract public String getItems();
	abstract public  long testDate();
	 abstract public long getDays();
	//Other Methods...
}

