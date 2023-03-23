import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.Rule;

import static org.junit.Assert.*;

public class TestL8Customer {

    @Rule
    public Timeout globalTimeout = Timeout.seconds(1); // 1 seconds max per method tested

    private static double grade = 0.0;

    @AfterClass
    public static void afterClass() {

        System.out.println(TestUtils.DIV);

        System.out.println("Grade for Customer (out of a possible 3.0): " + grade);

        System.out.println(TestUtils.DIV);

    }

    @Test
    public void testCustomerConstructorGetArrivalTime() {
      try{
        Customer someGuy = new Customer(5);
        assertEquals("ArrivalTime initialization in constructor", 5, someGuy.getArrivalTime());

        Customer fastGuy = new Customer(0);
        assertEquals("ArrivalTime initialization in constructor", 0, fastGuy.getArrivalTime());

        grade += 1;
      } catch (Exception e){
        System.out.println(TestUtils.EXCEPTION_DELIM);
        System.out.println("Exception thrown in test method testCustomerConstructorGetArrivalTime");
        e.printStackTrace();
        fail(e.toString());
      }
    }

    @Test
    public void testCustomerServeItems() {
      try{
        Customer someGuy = new Customer(5);
        int beforeItems = someGuy.getNumberOfItems();
        someGuy.serve();
        int afterItems = someGuy.getNumberOfItems();
        int diffItems = beforeItems - afterItems;
        assertEquals("Customer serve should decrease the number of items to be served", 1, diffItems);

        grade += 1;
      } catch (Exception e){
        System.out.println(TestUtils.EXCEPTION_DELIM);
        System.out.println("Exception thrown in test method testCustomerServeItems");
        e.printStackTrace();
        fail(e.toString());
      }
    }

    @Test
    public void testCustomerGetNumberOfServedItems() {
      try{
        Customer someGuy = new Customer(5);
        assertEquals("Initially, there are no served items", 0, someGuy.getNumberOfServedItems());
        someGuy.serve();
        assertEquals("Served one item", 1, someGuy.getNumberOfServedItems());
        someGuy.serve();
        someGuy.serve();
        assertEquals("Served multiple items", 3, someGuy.getNumberOfServedItems());

        grade += 1;
      } catch (Exception e){
        System.out.println(TestUtils.EXCEPTION_DELIM);
        System.out.println("Exception thrown in test method testCustomerGetNumberOfServedItems");
        e.printStackTrace();
        fail(e.toString());
      }
    }

    public static void main(String[] args) {

        TestUtils.runClass(TestL8Customer.class);

    }

}
