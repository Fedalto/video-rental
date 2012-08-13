package com.twu.refactor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

	private static final String GOLD_PATH = "test/data";

    private Customer dinsdale = new Customer("Dinsdale Pirhana");

    private static RegularMovieCategory regularMovieCategory=new RegularMovieCategory();
    private static ChildrenMovieCategory childrenMovieCategory=new ChildrenMovieCategory();
    private static NewReleaseCategory newReleaseCategory=new NewReleaseCategory();

    private Movie python = new Movie("Monty Python and the Holy Grail",regularMovieCategory);
	private Movie ran = new Movie("Ran", regularMovieCategory);
	private Movie la = new Movie("LA Confidential", newReleaseCategory);
	private Movie trek = new Movie("Star Trek 13.2", newReleaseCategory);
	private Movie wallace = new Movie("Wallace and Gromit", childrenMovieCategory);

    @Before
    public void setUpRentals (){
       dinsdale.addRental(new Rental (python, 3));
       dinsdale.addRental(new Rental (ran, 1));
       dinsdale.addRental(new Rental (la, 2));
       dinsdale.addRental(new Rental (trek, 1));
       dinsdale.addRental(new Rental (wallace, 6));
   }

    @Test
    public void shouldreturnEmptyStatement() throws Exception {
    	dinsdale = new Customer("Dinsdale Pirhana");
        equalsFile("1st Output", "outputEmpty", dinsdale.statement());
    }
    
    @Test
    public void testCustomer() throws Exception {
        equalsFile("1st Output", "output1", dinsdale.statement());
    }

    /*
    public void testHtml() throws Exception {
        equalsFile("1st Output", "outputHtml", dinsdale.htmlStatement());
    }
    */

    protected void equalsFile(String message, String fileName, String actualValue) throws IOException{
        BufferedReader file = new BufferedReader (new FileReader (GOLD_PATH + '/' + fileName));
        BufferedReader actualStream = new BufferedReader (new StringReader (actualValue));
        String thisFileLine = null;
        while  ((thisFileLine = file.readLine()) != null) {
            assertEquals ("in file: " + fileName, thisFileLine, actualStream.readLine());
        }
    }

}
