import java.io.Console;

/**
 * Created by Jason on 3/25/2016.
 */
public class Main {


    public static void main(String[] args){

        Rental  rental1 = new Rental(new Movie("Test Movie 1", Movie.CHILDRENS),1);
        Rental  rental2 = new Rental(new Movie("Test Movie 2", Movie.NEW_RELEASE),4);
        Rental  rental3 = new Rental(new Movie("Test Movie 3", Movie.REGULAR),3);
        Rental  rental4 = new Rental(new Movie("Test Movie 4", Movie.CHILDRENS),4);

        Customer customer = new Customer("Jason Wisener");
        customer.addRental(rental1);
        customer.addRental(rental2);
        customer.addRental(rental3);
        customer.addRental(rental4);

        String result = customer.statement();
        System.out.print(result);

    }

}
