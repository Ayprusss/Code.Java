public class Cashier {
    
    private Customer currentCustomer;
    private int customersServed;
    private int totalItemsServed;
    private int totalCustomerWaitTime;
    Queue<Customer> queue;

    public Cashier() {
        queue = new ArrayQueue<Customer>();
        totalCustomerWaitTime = 0;
        customersServed = 0;
        totalItemsServed = 0;

    }

    public void serveCustomers(int currentTime) {
        if (queue.isEmpty() && currentCustomer == null) {
            return;
        }

        if (currentCustomer == null) {
            currentCustomer = queue.dequeue();
            totalCustomerWaitTime += (currentTime - currentCustomer.getArrivalTime());
            customersServed ++;
        }

        currentCustomer.serve();

        if (currentCustomer.getNumberOfItems() == 0){
            totalItemsServed += currentCustomer.getNumberOfServedItems();
            currentCustomer = null;
        } 
    }

    public int getTotalCustomersServed() {
        return customersServed;
    }

    public void addCustomer(Customer c) {
        queue.enqueue(c);
    }

    public int getQueueSize() {
        return queue.size();
    }

    public int getTotalCustomerWaitTime() {
        return totalCustomerWaitTime;
    }

    public int getTotalItemsServed() {
        return totalItemsServed;
    }

    public String toString() {
        StringBuffer results = new StringBuffer();

        results.append("The total number of customers served is ");
        results.append(customersServed);
        results.append(" ");

        results.append("The average number of items per customer was ");
        results.append(totalItemsServed / customersServed);
        results.append(" ");

        results.append("The average waiting time (in sec) was ");
        results.append(totalCustomerWaitTime / customersServed);
        results.append(" ");

        return results.toString();


    }
}
