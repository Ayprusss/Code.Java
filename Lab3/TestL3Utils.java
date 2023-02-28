import org.junit.AfterClass;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.Timeout;

import static org.junit.Assert.*;

public class TestL3Utils {

    private static double grade = 0.0;
    @Rule
    public Timeout globalTimeout = Timeout.seconds(1); // 1 seconds max per method tested

    @AfterClass
    public static void afterClass() {

        System.out.println(TestUtils.DIV);

        System.out.println("Grade for Utils.findAndReplace (out of possible 5.0): " + grade);

        System.out.println(TestUtils.DIV);

    }

    @Test
    public void testNullParameter1() {

        String[] in = null;
        String[] what = { "hi" };
        String[] with = { "ho" };
        String[] expected = null;
        try{
            String[] result = Utils.findAndReplace( in, what, with );
            assertArrayEquals("Testing when \'in\' is null.", expected, result);
            grade += 0.5;
        }catch (NullPointerException e){
            fail("Not checking if \'in\' is null raises a NullPointerException.");
        }

    }

    @Test
    public void testNullParameter2() {

        String[] in = {"what"};
        String[] what = null;
        String[] with = null;
        String[] expected = null;
        try{
            String[] result = Utils.findAndReplace( in, what, with );
            assertArrayEquals("Testing when \'what\' is null.", expected, result);
            grade += 0.5;
        }catch (NullPointerException  e){
            fail("Not checking if \'what\' is null raises a NullPointerException.");
        }
    }

    @Test
    public void testNullParameter3() {

        String[] in = { "well" };
        String[] what = { "hi" };
        String[] with = null;
        String[] expected = null;
        try{
            String[] result = Utils.findAndReplace( in, what, with );

            assertArrayEquals("Testing when \'with\' contains a null element.", expected, result);
            grade += 0.5;
        }catch (NullPointerException  e){
            fail("Not checking if \'with\' is null raises a NullPointerException.");
        }
    }

    @Test
    public void testNullString2() {

        String[] in = { "hi" };
        String[] what = { null };
        String[] with = { null };
        String[] expected = null;
        String[] result = Utils.findAndReplace( in, what, with );

        assertArrayEquals("Testing when \'what\' contains a null element.", expected, result);
        grade += 0.5;
    }

    @Test
    public void testMismatchLength() {

        String[] in = { "hi", "ho" };
        String[] what = { "hi" };
        String[] with = { "hi", "ho" };
        String[] expected = null;
        String[] result = Utils.findAndReplace( in, what, with );

        assertArrayEquals("The \'what\' and \'with\' arrays have different lengths.", expected, result);
        grade += 0.5;
    }

    @Test
    public void testChangeFirst() {

        String[] in = { "I", "understand" };
        String[] what = { "I" };
        String[] with = { "You" };
        String[] expected = { "You", "understand" };
        String[] result = Utils.findAndReplace( in, what, with );

        assertArrayEquals("Changing the first element of the given array: { \"I\", \"understand\" } with {\"You\"}.", expected, result);
        grade += 0.5;
    }

    @Test
    public void testChangeLast() {

        String[] in = { "I", "understand" };
        String[] what = { "understand" };
        String[] with = { "see" };
        String[] expected = { "I", "see" };
        String[] result = Utils.findAndReplace( in, what, with );

        assertArrayEquals("Changing the second element of the give array: { \"I\", \"understand\" }, { \"understand\" }, { \"see\" }.", expected, result);
        grade += 0.5;
    }

    @Test
    public void testChangeAll() {

        String[] in = { "I", "like", "Java" };
        String[] what = { "I", "like", "Java" };
        String[] with = { "You", "love", "cats" };
        String[] expected = { "You", "love", "cats" };
        String[] result = Utils.findAndReplace( in, what, with );

        assertArrayEquals("Changing all the words in { \"I\", \"like\", \"Java\" } with { \"You\", \"love\", \"cats\" }.", expected, result);
        grade += 0.5;
    }

    @Test
    public void testChangeMultiInTheMiddle() {

        String[] in = { "You", "and", "Bob", "like", "Java", "very", "much" };
        String[] what = { "Bob", "Java", "like" };
        String[] with = { "I", "cats", "love" };
        String[] expected = { "You", "and", "I", "love", "cats", "very", "much" };
        String[] result = Utils.findAndReplace( in, what, with );

        assertArrayEquals("Changing multiple words in the middle of the array.", expected, result);
        grade += 0.5;
    }

    @Test
    public void testChangeFirstAndLast() {

        String[] in = { "I", "like", "Java" };
        String[] what = { "I", "Java", "like" };
        String[] with = { "You", "cats", "love" };
        String[] expected = { "You", "love", "cats" };
        String[] result = Utils.findAndReplace( in, what, with );

        assertArrayEquals("Changing the first and the last element.", expected, result);
        grade += 0.5;
    }

    public static void main(String[] args) {

        TestUtils.runClass(TestL3Utils.class);

    }
}
