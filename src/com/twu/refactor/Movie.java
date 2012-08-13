package com.twu.refactor;

public class Movie {
	private String title;
    private MovieCategory movieCategory;

   public Movie(String title,MovieCategory category) {
        this.title = title;
       this.movieCategory=category;
    }
	public String getTitle () {
		return title;
	}
    public double calculateAmountForGivenDays(int noOfdays){
        return movieCategory.calculateAmount(noOfdays);
    }

    public int calculateFrequentRenterPoints(int daysRented) {
        return movieCategory.calculateFrequentRenterPoints(daysRented);
    }
}

