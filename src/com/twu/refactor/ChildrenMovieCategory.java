package com.twu.refactor;

public class ChildrenMovieCategory extends MovieCategory {
    public double calculateAmount(int noOfDays){
        double amount = 1.5;
        if (noOfDays > 3){
            amount += (noOfDays - 3) * 1.5;
        }
        return amount;
    }
    public int calculateFrequentRenterPoints(int noOfDays){
        return  1;
    }
}
