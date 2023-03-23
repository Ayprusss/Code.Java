public class NotEnoughMoneyException extends IllegalStateException {

    public double value;
    private double balance;

    public NotEnoughMoneyException(double value, double balance) {
        super("You do not have enough money to withdraw " + value + "$.");
        this.value = value;
        this.balance = balance;
        
    }

    public double getAmount() {
        return value;
    }

    public double getBalance() {
        return balance;
    }

    public double getMissingAmount() {
        double missingAmount = value - balance;
        return (missingAmount);
    }


}