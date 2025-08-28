package ObjectOrientedDesign.CreditCardApp;

/**
 * A simple model for a consumer credit card.
 *
 * @author Michael T. Goodrich
 * @author Roberto Tamassia
 * @author Michael H. Goldwasser
 */
public class CreditCard {

    private final String customer;
    private final String bank;
    private final String account;
    private final int limit;
    protected double balance;

    /**
     * Constructs a new credit card instance.
     *
     * @param cust       the name of the customer (e.g., "John Bowman")
     * @param bk         the name of the bank (e.g., "California Savings")
     * @param acnt       the account identifier (e.g., "5391 0375 9387 5309")
     * @param lim        the credit limit (measured in dollars)
     * @param initialBal the initial balance (measured in dollars)
     */
    public CreditCard(String cust, String bk, String acnt, int lim, double initialBal) {
        customer = cust;
        bank = bk;
        account = acnt;
        limit = lim;
        balance = initialBal;
    }

    /*
    Charges the given price to the card, assuming sufficient credit limit.
            * @param price the amount to be charged
     * @return true if charge was accepted; false if charge was denied
     */
    public boolean charge(double price) {
        if (price + balance > limit) {
            return false; // refuse the charge
        }
        balance += price; // update the balance
        return true;
    }

    /**
     * Processes customer payment that reduces balance.
     * @param amount the amount of payment made
     */
    public void makePayment(double amount) {
        balance -= amount;
    }
}

