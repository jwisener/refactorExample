/**
 * Created by Jason on 3/25/2016.
 */
public class Movie {
    public static final int CHILDRENS = 2;
    public static final int REGULAR = 0;
    public static final int NEW_RELEASE = 1;

    private String title;
    private Price price;

    public Movie(String title, int priceCode){
        this.title = title;
        setPriceCode(priceCode);
    }

    public int getPriceCode() {
        return this.price.getPriceCode();
    }

    public void setPriceCode(int priceCode) {
        if(priceCode == CHILDRENS)
        {
            this.price = new ChildrensPrice();
        }
        else if(priceCode == NEW_RELEASE)
        {
            this.price = new NewReleasePrice();
        }
        else if(priceCode == REGULAR){
            this.price = new RegularPrice();
        }
        else{
            throw new IllegalArgumentException("Unknown price code");
        }
    }

    public String getTitle(){
        return this.title;
    }

    public double getPrice(int daysRented) {
        return this.price.getPrice(daysRented);
    }

    public int getFrequentRenterPoints(int daysRented) {
        return this.price.getFrequentRenterPoints(daysRented);
    }
}
