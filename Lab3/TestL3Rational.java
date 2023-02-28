import org.junit.AfterClass;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.Rule;

import static org.junit.Assert.*;

public class TestL3Rational {

    @Rule
    public Timeout globalTimeout = Timeout.seconds(1); // 1 seconds max per method tested

    private static double grade = 0.0;

    @AfterClass
    public static void afterClass() {

        System.out.println(TestUtils.DIV);

        System.out.println("Grade for Rational (out of possible 5.0): " + grade);

        System.out.println(TestUtils.DIV);

    }

    @Test
    public void testConstructor1() {
        Rational x = new Rational(3);
        assertEquals("Constructor with one parameter - initialization of the numerator instance variable", 3, x.getNumerator());
        assertEquals("Constructor with one parameter - default value for the denominator in Constructor.", 1, x.getDenominator());

        grade += 0.5;
    }

    @Test
    public void testConstructor2() {
        Rational x = new Rational(3,2);
        assertEquals("Constructor with two parameters - initialization of the numerator instance variable", 3, x.getNumerator());
        assertEquals("Constructor with two parameters - initialization of the denominator instance variable", 2, x.getDenominator());

        grade += 0.5;
    }

    @Test
    public void testConstructorReduce1() {
        Rational x = new Rational(15,6);
        assertEquals("Constructor(15,6) - should save the reduced form of the number: 5/2.", 5, x.getNumerator());
        assertEquals("Constructor(15,6) - should save the reduced form of the number: 5/2.", 2, x.getDenominator());

        grade += 0.5;
    }

    @Test
    public void testConstructorReduce2() {
        Rational x = new Rational(10,2);
        assertEquals("Constructor(10,2) - should save the reduced form of the number: 5,1.", 5, x.getNumerator());
        assertEquals("Constructor(10,2) - should save the reduced form of the number: 5,1.", 1, x.getDenominator());

        grade += 0.5;
    }

    @Test
    public void testPlusInstanceMethod() {
        Rational x = new Rational(1,2);
        Rational y = new Rational(1,4);
        Rational z = x.plus(y);

        assertEquals("The value of numerator after plus instance method call - new Rational(1,2).plus(new Rational(1,4))", 3, z.getNumerator());
        assertEquals("The value of denumerator after plus instance method call - new Rational(1,2).plus(new Rational(1,4))", 4, z.getDenominator());

        grade += 0.5;
    }

    @Test
    public void testPlusClassMethod() {
        Rational x = new Rational(5,4);
        Rational y = new Rational(-13,9);
        Rational z = Rational.plus(x,y);

        assertEquals("The value of numerator after plus class method call - Rational.plus(new Rational(5, 4), new Rational(-13, 9))", -7, z.getNumerator());
        assertEquals("The value of denumerator after plus class method call - Rational.plus(new Rational(5, 4), new Rational(-13, 9))", 36, z.getDenominator());

        grade += 0.5;
    }

    @Test
    public void testEquals1() {
        Rational x = new Rational(1,2);
        Rational y = new Rational(7,2);

        assertEquals("Equal with different numerators", false, x.equals(y));

        grade += 0.5;
    }

    @Test
    public void testEquals2() {
        Rational x = new Rational(1,2);
        Rational y = new Rational(-2,-4);

        assertEquals("Equal with a reducible fraction: 1/2 and -2/-4", true, x.equals(y));

        grade += 0.5;
    }

    @Test
    public void testCompareTo1() {
        Rational x = new Rational(1,2);
        Rational y = new Rational(3,4);

        assertEquals("Comparison smaller number: 1/2 with 3/4", true, x.compareTo(y) < 0);
        assertEquals("Comparison larger number: 3/4 with 1/2", true, y.compareTo(x) > 0);
        grade += 0.5;
    }

    @Test
    public void testCompareTo2() {
        Rational x = new Rational(1,2);
        Rational y = new Rational(2,4);

        assertEquals("Comparison with a reducible fraction", true, x.compareTo(y) == 0);
        assertEquals("Comparison with a reducible fraction", true, y.compareTo(x) == 0);
        grade += 0.5;
    }

    public static void main(String[] args) {

        TestUtils.runClass(TestL3Rational.class);

    }

}
