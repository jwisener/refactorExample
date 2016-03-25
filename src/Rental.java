/**
 * Created by Jason on 3/25/2016.
 */
public class Rental {
    private Movie movie;
    private int daysRented;
    private int frequentRenterPoints;

    public Rental(Movie movie, int daysRented){
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented(){
        return this.daysRented;
    }

    public Movie getMovie(){
        return this.movie;
    }

    public double getPrice(){
        return movie.getPrice(daysRented);
    }

    public int getFrequentRentalPoints(){

        return movie.getFrequentRenterPoints(daysRented);

    }
}
