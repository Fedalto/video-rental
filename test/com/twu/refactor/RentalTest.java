package com.twu.refactor;

import junit.framework.TestCase;

/**
 * Created with IntelliJ IDEA.
 * User: fedalto
 * Date: 8/13/12
 * Time: 10:44 AM
 * To change this template use File | Settings | File Templates.
 */
public class RentalTest extends TestCase {
    public void testCalculateAmount() throws Exception {
        Movie python = new Movie("Monty Python and the Holy Grail", Movie.REGULAR);
        Rental rental=new Rental(python,3);
        assertEquals(rental.calculateAmount(),3.5);
    }
    public void testCalculateFrequentRenterPoints(){
        Movie python = new Movie("Monty Python and the Holy Grail", Movie.NEW_RELEASE);
        Rental rental=new Rental(python,3);
        assertEquals(rental.calculateFrequentRenterPoints(),2);
    }
}
