/**
 * Created by Jason on 3/25/2016.
 */
public class Movie {
    static final int CHILDRENS = 2;
    static final int REGULAR = 0;
    static final int NEW_RELEASE = 1;

    private String title;
    private Price price;

    public Movie(String title, int priceCode){
        this.title = title;
        setPriceCode(priceCode);
    }

    private void setPriceCode(int priceCode) {

        //set the proper State based on the code type.
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
