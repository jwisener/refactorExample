import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import static org.junit.Assert.*;
/**
 * Created by Jason on 3/25/2016.
 */
public class CustomerStatementTest {

    private String fileContents = "";
    Customer customer = new Customer("Jason Wisener");

    static String readFile(String path, Charset encoding)
            throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

    @Before
    public void setUp() throws Exception {
        Rental  rental1 = new Rental(new Movie("Test Movie 1", Movie.CHILDRENS),1);
        Rental  rental2 = new Rental(new Movie("Test Movie 2", Movie.NEW_RELEASE),4);
        Rental  rental3 = new Rental(new Movie("Test Movie 3", Movie.REGULAR),3);
        Rental  rental4 = new Rental(new Movie("Test Movie 4", Movie.CHILDRENS),4);

        customer.addRental(rental1);
        customer.addRental(rental2);
        customer.addRental(rental3);
        customer.addRental(rental4);

        String result = customer.statement();
        System.out.print(result);

        Properties props = new Properties();

        URL resource = this.getClass().getResource("CustomerStatement.txt");
        String path = Paths.get(resource.toURI()).toString();

        fileContents = readFile(path,Charset.defaultCharset());
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void statement() throws Exception {
        String statement = customer.statement();
        System.out.println(statement);
        System.out.println(fileContents);
        assert(fileContents.equals(statement));
    }

}