/**
 * Created by Jason on 3/25/2016.
 * Create interface that the state strategies will use.
 */
public interface IStatementStrategy {
    String generateStatement(Customer customer);
}
