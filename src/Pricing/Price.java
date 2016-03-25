/**
 * Created by Jason on 3/25/2016.
 */
public abstract class Price {
       abstract int getPriceCode();
       abstract double getPrice(int daysRented);

       int getFrequentRenterPoints(int daysRented) {
              return 1;
       }
}
