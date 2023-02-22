import org.junit.AfterClass;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.Rule;

import java.util.Arrays;

import static org.junit.Assert.*;

public class TestL5Geometric {

    @Rule
    public Timeout globalTimeout = Timeout.seconds(1); // 1 seconds max per method tested

    private static double grade = 0.0;

    @AfterClass
    public static void afterClass() {

        System.out.println(TestUtils.DIV);

        System.out.println("Grade for Geometric (out of a possible 2): " + grade);

        System.out.println(TestUtils.DIV);

    }

    @Test
    public void testImplementsSeries() {
      Geometric s = new Geometric();
      assertTrue("class Geometric must extend AstractSeries which must implement Series", s instanceof Series);

      grade += 0.25;
    }

    @Test
    public void testExtendsAbstractSeries() {
      Geometric s= new Geometric();
      assertTrue("class Geometric must extend AbstractSeries", s instanceof AbstractSeries);

      grade += 0.25;
    }

    @Test
    public void testGeometricSeriesNextFourth() {
      Geometric geometric = new Geometric();
      geometric.next();
      geometric.next();
      geometric.next();
      double fourth = geometric.next();
      double expected = 1.875;

      assertEquals("Geometric fourth element", expected, fourth, 0.0001);

      grade += 0.25;
    }

    @Test
    public void testGeometricSeriesNextTenth() {
      Geometric geometric = new Geometric();
      for(int i = 0; i < 9; i++){
        geometric.next();
      }
      double tenth = geometric.next();
      double expected = 1.998046875;

      assertEquals("Geometric tenth element", expected, tenth, 0.0001);

      grade += 0.25;
    }

    @Test
    public void testGeometricSeriesValuesTake3() {
      Geometric s = new Geometric();
      double[] actual = s.take(3);
      double[] expected = new double[]{1, 1.5, 1.75};

      assertTrue("Geometric: take(3), expected: [1, 1.5, 1.75], actual: " + Arrays.toString(actual), Arrays.equals(expected, actual));

      grade += 0.5;
    }

    @Test
    public void testGeometricSeriesValuesTake12() {
      Geometric s = new Geometric();
      double[] actual = s.take(12);
      double[] expected = new double[]{1.0, 1.5, 1.75, 1.875, 1.9375, 1.96875, 1.984375, 1.9921875, 1.99609375, 1.998046875, 1.9990234375, 1.99951171875};

      assertTrue("Geometric: take(12), expected: [1.0, 1.5, 1.75, 1.875, 1.9375, 1.96875, 1.984375, 1.9921875, 1.99609375, 1.998046875, 1.9990234375, 1.99951171875], actual: " + Arrays.toString(actual), Arrays.equals(expected, actual));

      grade += 0.5;
    }

    public static void main(String[] args) {

        TestUtils.runClass(TestL5Geometric.class);

    }

}
