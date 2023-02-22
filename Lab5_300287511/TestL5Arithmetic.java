import org.junit.AfterClass;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.Rule;

import java.util.Arrays;

import static org.junit.Assert.*;

public class TestL5Arithmetic {

    @Rule
    public Timeout globalTimeout = Timeout.seconds(1); // 1 seconds max per method tested

    private static double grade = 0.0;

    @AfterClass
    public static void afterClass() {

        System.out.println(TestUtils.DIV);

        System.out.println("Grade for Arithmetic (out of a possible 2): " + grade);

        System.out.println(TestUtils.DIV);

    }

    @Test
    public void testExtendsAbstractSeries() {
      Arithmetic s = new Arithmetic();
      assertTrue("Arithmetic must extend AbstractSeries", s instanceof AbstractSeries);

      grade += 0.25;
    }

    @Test
    public void testImplementsSeries() {
      Arithmetic s = new Arithmetic();
      assertTrue("class Arithmetic must extend AstractSeries which must implement Series", s instanceof Series);

      grade += 0.25;
    }

    @Test
    public void testArithmeticSeriesNextFourth() {
      Arithmetic arithmetic = new Arithmetic();
      arithmetic.next();
      arithmetic.next();
      arithmetic.next();
      double fourth = arithmetic.next();
      double expected = 10;

      assertEquals("Arithmetic fourth element", expected, fourth, 0.0001);

      grade += 0.25;
    }

    @Test
    public void testArithmeticSeriesNextTenth() {
      Arithmetic s = new Arithmetic();
      for(int i = 0; i < 9; i++){
        s.next();
      }
      double tenth = s.next();
      double expected = 55;

      assertEquals("Arithmetic tenth element", expected, tenth, 0.0001);

      grade += 0.25;
    }

    @Test
    public void testArithmeticSeriesValuesTake3() {
      Arithmetic s = new Arithmetic();
      double[] actual = s.take(3);
      double[] expected = new double[]{1, 3, 6};

      assertTrue("Arithmetic: take(3), expected: [1, 3, 6], actual: " + Arrays.toString(actual), Arrays.equals(expected, actual));

      grade += 0.5;
    }

    @Test
    public void testArithmeticSeriesValuesTake12() {
      Arithmetic s = new Arithmetic();
      double[] actual = s.take(12);
      double[] expected = new double[]{1.0, 3.0, 6.0, 10.0, 15.0, 21.0, 28.0, 36.0, 45.0, 55.0, 66.0, 78.0};

      assertTrue("Arithmetic: take(12), expected: [1.0, 3.0, 6.0, 10.0, 15.0, 21.0, 28.0, 36.0, 45.0, 55.0, 66.0, 78.0], actual: " + Arrays.toString(actual), Arrays.equals(expected, actual));

      grade += 0.5;
    }

    public static void main(String[] args) {

        TestUtils.runClass(TestL5Arithmetic.class);

    }

}
