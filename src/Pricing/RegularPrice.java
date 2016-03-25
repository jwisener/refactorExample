/**
 * Created by Jason on 3/25/2016.
 */
public class RegularPrice extends Price {
    @Override
    int getPriceCode() {
        return Movie.REGULAR;
    }

    @Override
    public double getPrice(int daysRented) {
        double price = 2;
        if(daysRented > 2)
            price += (daysRented - 2) * 1.5;
        return price;
    }
}
