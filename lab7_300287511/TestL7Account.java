import org.junit.*;
import org.junit.rules.Timeout;

import static org.junit.Assert.*;
/**
 *
 * @author Diana Lucaci (dluca058@uottawa.ca)
 */
public class TestL7Account {

    @Rule
    public Timeout globalTimeout = Timeout.seconds(1); // 1 seconds max per method tested

    private static double grade = 0.0;

    @AfterClass
    public static void afterClass() {

        System.out.println(TestUtils.DIV);

        System.out.println("Grade for Account (out of a possible 2.0): " + grade);

        System.out.println(TestUtils.DIV);

    }

    @Test
    public void testConstructorGetBalance() {
        Account account = new Account();
        assertEquals("The initial balance should be 0",0, account.getBalance(), 0.0001);
        grade += 0.5;
    }

    @Test
    public void testDeposit() {
        Account account = new Account();
        account.deposit(10.37);
        assertEquals("The balance after deposit should be updated",10.37, account.getBalance(),0.0001);
        grade += 0.25;
    }

    @Test
    public void testWithdraw() {
        Account account = new Account();
        account.deposit(10.37);
        account.withdraw(5.37);
        assertEquals("The balance after a withdrawal should be updated",5.0, account.getBalance(),0.0001);
        grade += 0.25;
    }
    @Test(expected = NotEnoughMoneyException.class)
    public void testWithdrawThrowsNotEnoughMoneyException() {
        Account account = new Account();
        account.deposit(10.37);
        account.withdraw(15.37);
        grade += 0.5;
    }

    @Test
    public void testWithdrawThrowsNotEnoughMoneyExceptionGetAmount() {
        Account account = new Account();
        account.deposit(10.37);
        try {
            account.withdraw(15.37);
        } catch(NotEnoughMoneyException e){
            assertEquals("Amount saved by the exception", 15.37, e.getAmount(),0.0001);
            grade += 0.25;
        }
    }

    @Test
    public void testWithdrawThrowsNotEnoughMoneyExceptionGetBalance() {
        Account account = new Account();
        account.deposit(10.37);
        try {
            account.withdraw(15.37);
        } catch(NotEnoughMoneyException e){
            assertEquals("Amount saved by the exception", 15.37, e.getAmount(),0.0001);
            grade += 0.25;
        }
    }

    @Test
    public void testWithdrawThrowsNotEnoughMoneyExceptionGetMissingAmount() {
        Account account = new Account();
        account.deposit(10.37);
        try {
            account.withdraw(15.37);
        } catch(NotEnoughMoneyException e){
            assertEquals("Missing amount saved by the exception", 5.0, e.getMissingAmount(), 0.0001);
            grade += 0.5;
        }
    }

    public static void main(String[] args) {

        TestUtils.runClass(TestL7Account.class);

    }

}
