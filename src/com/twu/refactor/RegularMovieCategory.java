package com.twu.refactor;

public class RegularMovieCategory extends MovieCategory{
    public double calculateAmount(int noOfDays){
        double amount = 2;
        if (noOfDays> 2){
            amount += (noOfDays - 2) * 1.5;
        }
        return amount;
    }
    public int calculateFrequentRenterPoints(int noOfDays){
        return 1;
    }

}
