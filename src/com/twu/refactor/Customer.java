package com.twu.refactor;

import java.util.ArrayList;
import java.util.Iterator;

public class Customer {

	private String name;
	private ArrayList<Rental> rentalList = new ArrayList<Rental>();

	public Customer(String name) {
		this.name = name;
	}

	public void addRental(Rental arg) {
		rentalList.add(arg);
	}

	public String getName() {
		return name;
	}

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		String result = "Rental Record for " + getName() + "\n";

		for (Rental rental : rentalList) {
			double thisAmount = rental.calculateAmount();
            frequentRenterPoints += rental.calculateFrequentRenterPoints();
            result = getStatementLineForThisRental(result, thisAmount, rental);
            totalAmount += thisAmount;
		}
        result = addFooterLinesToRentalStatement(totalAmount, frequentRenterPoints, result);
		return result;
	}

     private String addFooterLinesToRentalStatement(double totalAmount, int frequentRenterPoints, String result) {
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints)
               +  " frequent renter points";
        return result;
    }

    private String getStatementLineForThisRental(String result, double thisAmount, Rental each) {
        result += "\t" + each.getMovie().getTitle() + "\t"
                + String.valueOf(thisAmount) + "\n";
        return result;
    }
}
