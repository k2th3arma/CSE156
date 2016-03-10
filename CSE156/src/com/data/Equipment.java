package com.data;

import org.joda.time.format.DateTimeFormatter;

public class Equipment extends Product{

	private String fee;
	private String numProduct;
	private String prodcutType;
	
	public String getProdcutType() {
		return prodcutType;
	}

	public void setProdcutType(String prodcutType) {
		this.prodcutType = prodcutType;
	}

	//Constructors
	public Equipment(String productCode, String productName, String fee) {
		super(productCode, productName);
		this.fee = fee;
	}
	
	//Getters and Setters
	public String getProductCode() {
		return productCode;
	}

	public String getProductName() {
		return productName;
	}

	public String getFee() {
		return fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}
	
	public String getNumProduct() {
		return numProduct;
	}

	public void setNumProduct(String numProduct) {
		this.numProduct = numProduct;
	}
	//Other Methods...

	@Override
	public String getItems() {
		
		return getProductName() + "  (" + getNumProduct() + "  units at  " + getFee() + "/units)";
	}

	@SuppressWarnings("null")
	@Override
	public long getDays() {
		// TODO Auto-generated method stub
		return ((Long) null);
	}

	@Override
	public long testDate() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getTotalFees() {
		// TODO Auto-generated method stub
		return "0.00";
	}

	@Override
	public double getSubtotal() {
		// TODO Auto-generated method stub
		
		return Double.parseDouble(getNumProduct()) * Double.parseDouble(getFee());
	}

	@Override
	public double getTax() {
		//if(getCustomerType().equals('B'));
		return 0.07;
	}

	@Override
	public String getCustomerTax() {
		// TODO Auto-generated method stub
		return null;
	}
}
