
/**
 * Created by Jason on 3/25/2016.
 */
public class NewReleasePrice extends Price {
    public int getPriceCode(){
        return Movie.NEW_RELEASE;
    }

    @Override
    public double getPrice(int daysRented) {
        return daysRented * 3;
    }

    int getFrequentRenterPoints(int daysRented) {
        return 2;
    }
}
