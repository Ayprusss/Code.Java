import org.junit.AfterClass;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.Rule;

import static org.junit.Assert.*;

public class TestL8Cashier {

    @Rule
    public Timeout globalTimeout = Timeout.seconds(1); // 1 seconds max per method tested

    private static double grade = 0.0;

    @AfterClass
    public static void afterClass() {

        System.out.println(TestUtils.DIV);

        System.out.println("Grade for Cashier (out of a possible 7.0): " + grade);

        System.out.println(TestUtils.DIV);

    }

    @Test
    public void testCashierConstructor() {
      try{
        Cashier cashier = new Cashier();
        assertEquals("Cashier get initial total customer wait time", 0, cashier.getTotalCustomerWaitTime());
        assertEquals("Cashier get initial total items served", 0, cashier.getTotalItemsServed());
        assertEquals("Cashier get initial total customers served", 0, cashier.getTotalCustomersServed());

        grade += 1;
      } catch (Exception e){
        System.out.println(TestUtils.EXCEPTION_DELIM);
        System.out.println("Exception thrown in method testCashierConstructor");
        e.printStackTrace();
        fail(e.toString());
      }
    }

    @Test
    public void testCashierServeEmpty() {
      try{
        Cashier cashier = new Cashier();
        cashier.serveCustomers(5);
        assertEquals("Cashier with no customers - total wait time", 0, cashier.getTotalCustomerWaitTime());
        assertEquals("Cashier with no customers - total items served", 0, cashier.getTotalItemsServed());
        assertEquals("Cashier with no customers - total customers served", 0, cashier.getTotalCustomersServed());

        grade += 1;
      } catch (Exception e){
        System.out.println(TestUtils.EXCEPTION_DELIM);
        System.out.println("Exception thrown in method testCashierServeEmpty");
        e.printStackTrace();
        fail(e.toString());
      }
    }

    @Test
    public void testCashierServeOne() {
      try{
        Cashier cashier = new Cashier();
        Customer customer = new Customer(5);
        cashier.addCustomer(customer);

        assertEquals("Queue size with one customer", 1, cashier.getQueueSize());
        grade += 0.5;

        int items = customer.getNumberOfItems();

        for (int i = 0; i < items; i++) {
          cashier.serveCustomers(10);
        }

        assertEquals("Queue size after finishing to serve all items", 0, cashier.getQueueSize());
        grade += 0.5;

        assertEquals("Total number of items served after one customer", items, cashier.getTotalItemsServed());
        assertEquals("Total customers served after one customer", 1, cashier.getTotalCustomersServed());
        grade += 0.5;

        assertEquals("Total wait time after one customer", 5, cashier.getTotalCustomerWaitTime());
        grade += 0.5;
      } catch (Exception e){
        System.out.println(TestUtils.EXCEPTION_DELIM);
        System.out.println("Exception thrown in method testCashierServeOne");
        e.printStackTrace();
        fail(e.toString());
      }
    }

    @Test
    public void cashierServeTwo() {
      try{
        Cashier cashier = new Cashier();
        Customer customer1 = new Customer(5);
        Customer customer2 = new Customer(10);
        cashier.addCustomer(customer1);
        cashier.addCustomer(customer2);

        assertEquals("Queue size with 2 customers", 2, cashier.getQueueSize());
        grade += 0.5;

        int items1 = customer1.getNumberOfItems();
        int items2 = customer2.getNumberOfItems();

        for (int i = 0; i < items1; i++) {
          cashier.serveCustomers(10);
        }

        assertEquals("Total customers served after one customer", 1, cashier.getTotalCustomersServed());
        grade += 0.25;

        assertEquals("Total customers remained in queue after one customer", 1, cashier.getQueueSize());
        grade += 0.25;

        for (int i = 0; i < items2; i++) {
          cashier.serveCustomers(15);
        }

        assertEquals("Total customers served after 2 customers", 2, cashier.getTotalCustomersServed());
        grade += 0.5;

        assertEquals("Total items served after 2 customers", items1 + items2, cashier.getTotalItemsServed());
        grade += 0.5;

        assertEquals("Total wait time for multiple customers", 10, cashier.getTotalCustomerWaitTime());
        grade += 0.5;

        assertEquals("Queue size with no customers left", 0, cashier.getQueueSize());
        grade += 0.5;
      } catch (Exception e){
        System.out.println(TestUtils.EXCEPTION_DELIM);
        System.out.println("Exception thrown in method testCashierServeOne");
        e.printStackTrace();
        fail(e.toString());
      }
    }

    public static void main(String[] args) {

        TestUtils.runClass(TestL8Cashier.class);

    }

}
