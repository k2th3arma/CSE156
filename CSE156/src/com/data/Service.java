package com.data;

import java.util.Calendar;
import java.util.Date;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.Days;
import org.joda.time.format.DateTimeFormat;
import java.time.temporal.ChronoUnit;
import java.time.LocalDate;

public class Service extends Product {

	private String activationFee;
	private String annualFee;
	private String serviceCode;
	public String setNumProduct;
	private String startDate;
	private String endDate;

	private int numdays;
	private long DAYS;

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	// Constructor
	public Service(String productCode, String productName, String activationFee, String annualFee) {
		super(productCode, productName);
		this.activationFee = activationFee;
		this.annualFee = annualFee;
	}

	// Setters and Getters
	public String getProductCode() {
		return productCode;
	}

	public String getProductName() {
		return productName;
	}

	public String getActivationFee() {
		return activationFee;
	}

	public void setActivationFee(String activationFee) {
		this.activationFee = activationFee;
	}

	public String getAnnualFee() {
		return this.annualFee;
	}

	public void setAnnualFee(String annualFee) {
		this.annualFee = annualFee;
	}

	public String getItems() {
		// TODO Auto-generated method stub
		return getProductName() + "  (" + testDate() + " days at $" + getAnnualFee() + "/yr)";
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	@Override

	public double getSubtotal() {
		double mid = (testDate());
		return (mid / 365) * Double.parseDouble(getAnnualFee());
	}

	@Override
	public long getDays() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long testDate() {

		LocalDate dateBefore = LocalDate.parse(getStartDate());
		LocalDate dateAfter = LocalDate.parse(getEndDate());
		long daysBetween = ChronoUnit.DAYS.between(dateBefore, dateAfter);
		return daysBetween + 1;// TODO Auto-generated method stub
	}

	@Override
	public double getTotalFees() {
		// TODO Auto-generated method stub
		return Double.parseDouble(getActivationFee());
	}

	@Override
	public double getTax() {
		// TODO Auto-generated method stub
		return .0425;
	}

	@Override
	public double getCustomerTax() {
		// TODO Auto-generated method stub
		return getTax() * getSubtotal();
	}

	// Other Methods...
}
