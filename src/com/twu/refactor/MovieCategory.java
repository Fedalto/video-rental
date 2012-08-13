package com.twu.refactor;

public abstract class MovieCategory {
    public MovieCategory(){
    }
    public abstract double calculateAmount(int noOfDays);
    public abstract int calculateFrequentRenterPoints(int noOfDays);
}