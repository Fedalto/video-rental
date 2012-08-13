package com.twu.refactor;


import org.junit.Test;

import static junit.framework.Assert.assertEquals;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RentalTest {

    private static RegularMovieCategory regularMovieCategory=new RegularMovieCategory();
    private static ChildrenMovieCategory childrenMovieCategory=new ChildrenMovieCategory();
    private static NewReleaseCategory newReleaseCategory=new NewReleaseCategory();

    @Test
    public void testCalculateAmount() throws Exception {
        Movie python = new Movie("Monty Python and the Holy Grail",regularMovieCategory );
        Rental rental=new Rental(python,3);
        assertThat(rental.calculateAmount(), is(3.5));
    }

    @Test
    public void testCalculateFrequentRenterPointsNewRelease(){
        Movie trek = new Movie("Star Trek 13.2", newReleaseCategory);
        Rental rental=new Rental(trek, 3);
        assertThat(rental.calculateFrequentRenterPoints(), is(2));
    }

    @Test
    public void testCalculateAmountforChildrenMovie() throws Exception {
        Movie python = new Movie("Monty Python and the Holy Grail",childrenMovieCategory);
        Rental rental=new Rental(python,4);
        assertThat(rental.calculateAmount(), is(3.0));
    }

    @Test
    public void testCalculateFrequentRenterPointsForRegularMovie(){
        Movie python = new Movie("Monty Python and the Holy Grail",regularMovieCategory);
        Rental rental=new Rental(python, 3);
        assertEquals(rental.calculateFrequentRenterPoints(), 1);
    }



    @Test
    public void testCalculateFrequentRenterPointsForNewReleaseMovie(){
        Movie python = new Movie("Monty Python and the Holy Grail",newReleaseCategory);
        Rental rental=new Rental(python, 3);
        assertEquals(rental.calculateFrequentRenterPoints(), 2);
    }
}
