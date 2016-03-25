import java.util.ArrayList;
/**
 * Created by Jason on 3/25/2016.
 */
public class Customer {
    private String name;
    private ArrayList<Rental> rentals = new ArrayList<>();
    private IStatementStrategy statementStrategy;

    public Customer(String name){
        this.name = name;

        //set the statement strategy;
        setStatementStrategy();
    }

    /** jason wisener
     * 3/25/16 Set the statement strategy
     * to use the Text Version, this can
     * be extended by generating a new Strategy
     * and implementing the functionality (html, pdf, etc..)
     */
    private void setStatementStrategy() {
        //set the statement strategy, usually here I would DI, in a startup
        //type module.
        this.statementStrategy = new StatementTextStrategy();
    }

    public void addRental(Rental rental){
        this.rentals.add(rental);
    }

    public String getName(){
        return name;
    }

    public ArrayList<Rental> getRentals(){
        return this.rentals;
    }

    public double getTotalPrice(){
        double totalAmount = 0;
        for(Rental rental : this.getRentals()){
            totalAmount += rental.getPrice();
        }
        return totalAmount;
    }

    public int getTotalFrequentRenterPoints(){
        int totalFrequentRentalPoints = 0;
        for(Rental rental : this.getRentals()){
            totalFrequentRentalPoints += rental.getFrequentRentalPoints();
        }
        return totalFrequentRentalPoints;
    }

    public String statement(){

        return statementStrategy.generateStatement(this);

        //refactor the code below.
        /*
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        String result = "Rental Record for " + getName() + "\n";
        for(Rental rental : rentals){
            double thisAmount = 0;

            switch(rental.getMovie().getPriceCode()){
                case Movie.REGULAR:
                    thisAmount += 2;
                    if(rental.getDaysRented() > 2)
                        thisAmount += (rental.getDaysRented() - 2) * 1.5;
                    break;
                case Movie.NEW_RELEASE:
                    thisAmount += rental.getDaysRented() * 3;
                    break;
                case Movie.CHILDRENS:
                    thisAmount += 1.5;
                    if(rental.getDaysRented() > 3)
                        thisAmount += (rental.getDaysRented()) * 1.5;
                    break;
            }
            frequentRenterPoints ++;

            if((rental.getMovie().getPriceCode() == Movie.NEW_RELEASE) && rental.getDaysRented() > 1)
                frequentRenterPoints++;

            result += "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }


        result += "amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;
        */
    }
}
