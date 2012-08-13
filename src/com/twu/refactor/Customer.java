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
		Iterator<Rental> rentals = rentalList.iterator();
		String result = "Rental Record for " + getName() + "\n";
		while (rentals.hasNext()) {
			double thisAmount = 0;
			Rental currentRental = rentals.next();
            thisAmount += currentRental.calculateAmount();
            frequentRenterPoints += calculateFrequentRenterPoints(currentRental);
            result = getStatementLineForThisRental(result, thisAmount, currentRental);
            totalAmount += thisAmount;

		}
        result = addFooterLinesToRentalStatement(totalAmount, frequentRenterPoints, result);
		return result;
	}

    private int calculateFrequentRenterPoints(Rental currentRental) {

        int frequentRenterPoints = 1;
        // add bonus for a two day new release rental
        if ((currentRental.getMovie().getPriceCode() == Movie.NEW_RELEASE)
                && currentRental.getDaysRented() > 1)
            frequentRenterPoints++;
        return frequentRenterPoints;
    }

    private String addFooterLinesToRentalStatement(double totalAmount, int frequentRenterPoints, String result) {
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints)
                + " frequent renter points";
        return result;
    }

    private String getStatementLineForThisRental(String result, double thisAmount, Rental each) {
        result += "\t" + each.getMovie().getTitle() + "\t"
                + String.valueOf(thisAmount) + "\n";
        return result;
    }
}
