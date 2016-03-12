package com.output;
/* MWC program
* ---designed and built by Ronnie Gallagher and Jacob Reis
* Description: 
* 	
*/

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

	public InvoiceReport(List<Person> persons, List<Customer> customers, List<Product> products) {
		this.persons = persons;
		this.customers = customers;
		this.products = products;

	}

	public static void main(String[] args) {

		// Create a FlatFileReader object
		FileReader fp = new FileReader();

		List<Person> personList = fp.readPersons();

		List<Customer> customerList = fp.readCustomer();

		List<Product> productList = fp.readProduct();

		List<Invoice> invoiceList = fp.readInvoice();

		List<Product> invoiceProduct = fp.readProduct();

		String fileName = "data/output.txt";
		try {
			PrintWriter outputStream = new PrintWriter(fileName);

			outputStream.println("INVOICE SUMMARY REPORT");
			outputStream.println("========================================");
			StringBuilder sb = new StringBuilder();
			StringBuilder to = new StringBuilder();
			sb.append(String.format("%-12s %-30s %-30s %-9s %9s %9s %9s\n", "Invoice", "Customer", "Salesperson",
					"SubTotal", "Fees", "Taxes", "Total"));
			// invoice number
			double subfee = 0;
			Customer cust = null;
			double finalTot = 0;
			double subtot = 0;
			double sumTaxes = 0;
			double totalTaxes = 0;
			double totalTaxes1 = 0;
			double fees = 0;
			Product sub = null;
			// Invoice loop
			for (Invoice i : invoiceList) {

				double num = 0;
				sumTaxes = 0;
				fees = 0;
				// Customer cust = null;
				for (Customer c : customerList) {
					if (c.getCustomerCode().equals(i.getCustomerCode())) {
						cust = c;
					}
				}
				// Find the persons

				Person per = null;
				for (Person p : personList) {
					if (p.getPersonCode().equals(i.getSalesPerson().getPersonCode())) {
						per = p;
					}
				}

				// Product sub = null;
				for (Product pd : i.getProductData()) {
					sub = pd;
					for (int a = 0; a < sub.getSubtotal(); a++) {
						num += sub.getSubtotal();
						break;
					}
					// finding the taxes
					for (int a = 0; a < sub.getCustomerTax(); a++) {
						if (cust.getCustomerType().equals("R")) {
							sumTaxes = cust.getTax();
							break;
						}
						if (cust.getCustomerType().equals("B")) {
							sumTaxes += sub.getCustomerTax();
							break;
						}
					}
					// getting the fees
					for (int f = 0; f < sub.getTotalFees(); f++) {
						fees += sub.getTotalFees();
						break;
					}
					// getting the subtotal
					for (int l = 0; l < sub.getSubtotal(); l++) {
						finalTot += sub.getSubtotal();
						break;
					}

					// geting the total fees
					for (int n = 0; n < sub.getTotalFees(); n++) {
						if (cust.getCustomerType().equals("R")) {
							subtot = ((subtot + sub.getTotalFees()) + cust.compliaceFee());
							break;
						} else {
							subtot += sub.getTotalFees();
							break;
						}
					}

					// geting the total sum of the taxes
					for (int a = 0; a < sub.getCustomerTax(); a++) {

						if (cust.getCustomerType().equals("R")) {
							totalTaxes += cust.getTax();
							// totalTaxes+=sumTaxes;
							break;
						}

						if (cust.getCustomerType().equals("B")) {
							totalTaxes += sub.getCustomerTax();
							// totalTaxes+=sumTaxes;
							break;
						}

					}
				}

				sb.append(String.format("%-10s %-30s %-30s $%9.2f $%9.2f $%9.2f $%9.2f\n", i.getInvoiceCode(),
						cust.getCustomerName(), per.getName(), num, fees + cust.compliaceFee(), sumTaxes,
						(num + fees + sumTaxes))); // TODO: replace these

			}
			to.append(String.format("%-10s %61s $%9.2f $%9.2f $%9.2f $%9.2f\n", "TOTALS ", "", finalTot, subtot,
					totalTaxes, (finalTot + subtot + totalTaxes)));
			outputStream.print(sb);
			// outputStream.println(to);
			outputStream.println(
					"=========================================================================================================================================");

			outputStream.println(to);

			outputStream.println("================================");
			outputStream.println("Invoice Detail Report");
			outputStream.println("================================");

			// second

			for (Invoice inv : invoiceList) {
				StringBuilder nb = new StringBuilder();

				nb.append(String.format("%-10s %-50s %-9s %9s %9s %9s\n", "Code", "Item", "SubTotal", "Taxes", "Fees",
						"Total"));

				for (Customer c : customerList) {
					if (c.getCustomerCode().equals(inv.getCustomerCode())) {
						cust = c;
					}
				}
				Person aPerson = null;
				for (Person p : personList) {
					if (p.getPersonCode().equals(inv.getSalesPerson().getPersonCode())) {
						aPerson = p;
					}
				}

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
				outputStream.println("           " + cust.getAddress().getCity() + "," + cust.getAddress().getState()
						+ " " + cust.getAddress().getZip() + " " + cust.getAddress().getCountry());
				outputStream.println("------------------------------------");

				StringBuilder sum = new StringBuilder();
				StringBuilder cop = new StringBuilder();
				StringBuilder com = new StringBuilder();

				double eq = 0;
				double sumTax = 0;
				double feeSum = 0;
				double tot = 0;
				Product ped = null;

				for (Product pd : inv.getProductData()) {

					ped = pd;
					for (int n = 0; n < ped.getSubtotal(); n++) {
						eq += ped.getSubtotal();
						break;
					}
					for (int a = 0; a < ped.getCustomerTax(); a++) {
						if (cust.getCustomerType().equals("R")) {
							sumTax = 0;
							break;
						}
						if (cust.getCustomerType().equals("B")) {
							sumTax += ped.getCustomerTax();
							break;
						}

					}
					for (int f = 0; f < ped.getTotalFees(); f++) {

						feeSum += ped.getTotalFees();
						break;
					}
					for (int l = 0; l < eq; l++) {
						tot += eq;
						break;
					}

					nb.append(String.format("%-10s %-50s $%9.2f $%9.2f $%9.2f\n", ped.getProductCode(), ped.getItems(),
							ped.getSubtotal(), (ped.getCustomerTax()), ped.getTotalFees()));
				}
				outputStream.println(nb);
				outputStream.println(
						"                                                              =====================================");
				sum.append(String.format("%-10s %-50s $%9.2f $%9.2f $%9.2f $%9.2f", "SUB-TOTALS", "      ", eq, sumTax,
						feeSum, (eq + sumTax + feeSum)));
				outputStream.println(sum);
				cop.append(String.format("%-10s %-79s $%9.2f", "COMPLIANCE FEE", "", (cust.compliaceFee())));
				outputStream.println(cop);
				com.append(String.format("%-10s %-82s $%9.2f", "FINAL TOTAL", "",
						(eq + sumTax + feeSum) + cust.compliaceFee()));
				outputStream.println(com);
			}
			outputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}
}
