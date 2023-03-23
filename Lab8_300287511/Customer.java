import java.util.Random;

public class Customer {

    private int arrivalTime;   
    private int initialNumberOfItems;
    private int numberOfItems;
    private int MAX_NUM_ITEMS = 25;
    Random generator;

    public Customer(int arrivalTime) {

        this.arrivalTime = arrivalTime;
        this.numberOfItems = (int) (((MAX_NUM_ITEMS - 1) * Math.random()) + 1);
        this.initialNumberOfItems = numberOfItems;


    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getNumberOfItems() {
        return numberOfItems;
    }

    public int getNumberOfServedItems() {
        return initialNumberOfItems - numberOfItems;
    }

    public void serve() {
        numberOfItems --;
    }
}
