package com.twu.refactor;

import junit.framework.TestCase;

public class RentalTest extends TestCase {
    public void testCalculateAmount() throws Exception {
        Movie python = new Movie("Monty Python and the Holy Grail", Movie.REGULAR);
        Rental rental=new Rental(python,3);
        assertEquals(rental.calculateAmount(),3.5);
    }
    public void testCalculateFrequentRenterPointsNewRelease(){
        Movie trek = new Movie("Star Trek 13.2", Movie.NEW_RELEASE);
        Rental rental=new Rental(trek, 3);
        assertEquals(rental.calculateFrequentRenterPoints(),2);
    }

    public void testCalculateFrequentRenterPoints(){
        Movie python = new Movie("Monty Python and the Holy Grail", Movie.REGULAR);
        Rental rental=new Rental(python, 3);
        assertEquals(rental.calculateFrequentRenterPoints(), 1);
    }
}
