/**
 * Created by Jason on 3/25/2016.
 * This will generate a text statement of a customer's statement.
 */
public class StatementTextStrategy implements IStatementStrategy {

    @Override
    public String generateStatement(Customer customer) {
        int frequentRenterPoints = customer.getTotalFrequentRenterPoints();
        double totalPrice = customer.getTotalPrice();

        String result = "Rental Record for " + customer.getName() + "\r\n";
        for(Rental rental : customer.getRentals()){
            result += "\t" + rental.getMovie().getTitle() + "\t" + String.valueOf(rental.getPrice()) + "\r\n";
        }

        result += "amount owed is " + String.valueOf(totalPrice) + "\r\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;
    }
}
