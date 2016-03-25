/**
 * Created by Jason on 3/25/2016.
 */
public class ChildrensPrice extends Price {


    @Override
    public double getPrice(int daysRented) {
        double price = 1.5;
        if(daysRented > 3)
            price += daysRented * 1.5;
        return price;

    }
}
