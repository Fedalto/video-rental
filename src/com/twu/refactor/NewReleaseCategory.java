package com.twu.refactor;

public class NewReleaseCategory extends MovieCategory{
    public double calculateAmount(int noOfDays){
        return noOfDays * 3;
    }
    public int calculateFrequentRenterPoints(int noOfDays){
        return  noOfDays>1?2:1;
    }

}
