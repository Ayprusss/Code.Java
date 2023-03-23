public class Account {
    
    private double balance;
    private double value;


    public Account() {
        this.balance = 0;
    }

    public double deposit(double value) {
        balance = balance + value;
        System.out.println("New Balance = " + balance + "$.");
        return balance;
    }
    public double withdraw(double value) {
        this.value = value;

        if (value > balance) {
            throw new NotEnoughMoneyException( value, balance);
        }
        balance -= value;
        System.out.println("New Balance = " + balance + "$.");

        return balance;
    }

    public double getValue() {
        return value;
    }
    public double getBalance() {
        return balance;
    }


} 
