import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Jason on 3/25/2016.
 */
public class MovieUnknownPriceCodeTest {

    private IllegalArgumentException ex;
    @Before
    public void setUp(){
        ex = null;
    }

    @After
    public void tearDown(){

    }

    @Test
    public void createAMovieWithUnknownPriceCodeShouldThrowException() {
        try {
            Movie movie = new Movie("Invalid", -50);
        } catch (IllegalArgumentException invalidArgument) {
            ex = invalidArgument;
        }

        assert(ex != null);
        assert(ex.getMessage().equals("Unknown price code"));
    }



}