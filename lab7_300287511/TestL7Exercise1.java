import org.junit.*;
import org.junit.rules.Timeout;

import static org.junit.Assert.*;
/**
 *
 * @author Diana Lucaci (dluca058@uottawa.ca)
 */
public class TestL7Exercise1 {

    @Rule
    public Timeout globalTimeout = Timeout.seconds(1); // 1 seconds max per method tested

    private static double grade = 0.0;

    @AfterClass
    public static void afterClass() {

        System.out.println(TestUtils.DIV);

        System.out.println("Grade for Exercise1 (out of a possible 1.0): " + grade);

        System.out.println(TestUtils.DIV);

    }

    @Test
    public void testRandomException1() {
        String exceptionName = Exercise1.catchException(1);
        assertEquals("Throwing Exception", "Exception", exceptionName);
        grade += 0.25;
    }

    @Test
    public void testRandomException2() {
        String exceptionName = Exercise1.catchException(2);
        assertEquals("Throwing ArrayIndexOutOfBoundsException", "ArrayIndexOutOfBoundsException", exceptionName);
        grade += 0.15;
    }

    @Test
    public void testRandomException3() {
        String exceptionName = Exercise1.catchException(3);
        assertEquals("Throwing IOException", "IOException", exceptionName);
        grade += 0.15;
    }

    @Test
    public void testRandomException4() {
        String exceptionName = Exercise1.catchException(4);
        assertEquals("Throwing IllegalArgumentException", "IllegalArgumentException", exceptionName);
        grade += 0.15;
    }

    @Test
    public void testRandomException5() {
        String exceptionName = Exercise1.catchException(5);
        assertEquals("Throwing NullPointerException", "NullPointerException", exceptionName);
        grade += 0.15;
    }

    @Test
    public void testRandomExceptionNoException() {
        String exceptionName = Exercise1.catchException(15);
        assertEquals("NoException thrown", "NoException", exceptionName);
        grade += 0.15;
    }

    public static void main(String[] args) {

        TestUtils.runClass(TestL7Exercise1.class);

    }

}
