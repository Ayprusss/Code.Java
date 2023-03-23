import java.util.NoSuchElementException;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 *
 * @author Marcel Turcotte (turcotte@eecs.uottawa.ca)
 * @author Diana Lucaci (dluca058@uottawa.ca)
 */
public class TestL7Dictionary {

    @Rule
    public Timeout globalTimeout = Timeout.seconds(1); // 1 seconds max per method tested

    private static double grade = 0.0;

    @AfterClass
    public static void afterClass() {

        System.out.println(TestUtils.DIV);

        System.out.println("Grade for Dictionary (out of a possible 4.0): " + grade);

        System.out.println(TestUtils.DIV);

    }

    @Test
    public void testGetNoSuchElementException() {
        Dictionary dict = new Dictionary();
        try {
            dict.get("V");
            fail("Get inexistent key should raise NoSuchElementException");
        } catch (NoSuchElementException e){
            grade += 0.25;
        } catch(Exception e){
            fail("Exception raised during test: " + e.toString());
        }
    }

    @Test
    public void testGetNoSuchElementExceptionNonEmpty() {
        try {
            Dictionary dict = new Dictionary();
            dict.put("X", 1);
            dict.put("Y", 2);
            dict.put("Z", 3);
            dict.get("V");
            fail("Get inexistent key should raise NoSuchElementException");
        } catch (NoSuchElementException e) {
            grade += 0.5;
        } catch(Exception e){
            fail("Exception raised during test: " + e.toString());
        }
    }

    @Test
    public void testGetNullPointerException() {
        try {
            Dictionary dict = new Dictionary();
            dict.get(null);
            fail("Get null key should raise a NullPointerException");
        } catch(NullPointerException e) {
            grade += 0.25;
        } catch(Exception e){
            fail("Get method failed to raise NullPointerException, instead: " + e.toString());
        }
    }

    @Test
    public void testContainsNullPointerException() {
        Dictionary dict = new Dictionary();
        try {
            dict.contains(null);
            fail("Searching for a null key should raise NullPointerException");
        } catch (NullPointerException e){
            grade += 0.25;
        } catch(Exception e){
            fail("Contains method failed to raise NullPointerException, instead: " + e.toString());
        }
    }

    @Test
    public void testPutNullPointerExceptionKey() {
        Dictionary dict = new Dictionary();
        try {
            dict.put(null, 1);
            fail("Putting a null key should raise NullPointerException");
        } catch (NullPointerException e){
            grade += 0.25;
        } catch(Exception e){
            fail("Exception raised during test: " + e.toString());
        }
    }

    @Test
    public void testPutNullPointerExceptionValue() {
        Dictionary dict = new Dictionary();
        try {
            dict.put("X", null);
            fail("Putting a null value should raise NullPointerException");
        } catch (NullPointerException e){
            grade += 0.25;
        } catch(Exception e){
            fail("Exception raised during test: " + e.toString());
        }
    }

    @Test
    public void testPutNullPointerExceptionKeyValue() {
        Dictionary dict = new Dictionary();
        try {
            dict.put(null, null);
            fail("Putting a null key and null value should raise NullPointerException");
        } catch (NullPointerException e){
            grade += 0.25;
        } catch(Exception e){
            fail("Exception raised during test: " + e.toString());
        }
    }

    @Test
    public void testReplaceNullPointerExceptionKey() {
        Dictionary dict = new Dictionary();
        try{
            dict.replace(null, 1);
            fail("Replacing a null key should raise NullPointerException");
        } catch (NullPointerException e){
            grade += 0.25;
        } catch(Exception e){
            fail("Exception raised during test: " + e.toString());
        }
    }

    @Test
    public void testReplaceNullPointerExceptionValue() {
        Dictionary dict = new Dictionary();
        try{
            dict.replace("X", null);
            fail("Replacing a null value should raise NullPointerException");
        } catch (NullPointerException e){
            grade += 0.25;
        } catch(Exception e){
            fail("Exception raised during test: " + e.toString());
        }
    }

    @Test
    public void testReplaceNullPointerExceptionKeyValue() {
        Dictionary dict = new Dictionary();
        try{
            dict.replace(null, null);
            fail("Replacing a null key and a null value should raise NullPointerException");
        } catch (NullPointerException e){
            grade += 0.25;
        } catch(Exception e){
            fail("Exception raised during test: " + e.toString());
        }
    }

    @Test
    public void testReplaceNoSuchElementException() {
        Dictionary dict = new Dictionary();
        try{
            dict.replace("V", 1);
            fail("Replacing an inexistent key should raise NoSuchElementException");
        } catch (NoSuchElementException e){
            grade += 0.25;
        } catch(Exception e){
            fail("Exception raised during test: " + e.toString());
        }
    }

    @Test
    public void testReplaceNonEmptyNoSuchElementException() {
        Dictionary dict = new Dictionary();
        dict.put("X", 1);
        try{
            dict.replace("V", 1);
            fail("Replacing an inexistent key should raise NoSuchElementException");
        } catch (NoSuchElementException e){
            grade += 0.25;
        } catch(Exception e){
            fail("Exception raised during test: " + e.toString());
        }
    }

    @Test
    public void testRemoveNullPointerException() {
        Dictionary dict = new Dictionary();
        try{
            dict.remove(null);
            fail("Removing a null key value should raise NullPointerException");
        } catch (NullPointerException e){
            grade += 0.25;
        } catch(Exception e){
            fail("Exception raised during test: " + e.toString());
        }
    }

    @Test
    public void testRemoveNoSuchElementException() {
        Dictionary dict = new Dictionary();
        try{
            dict.remove("V");
            fail("Removing an inexitent key should raise NoSuchElementException");
        } catch (NoSuchElementException e){
            grade += 0.25;
        } catch(Exception e){
            fail("Exception raised during test: " + e.toString());
        }
    }

    @Test
    public void testRemoveNoSuchElementExceptionNonEmpty() {
        Dictionary dict = new Dictionary();
        dict.put("X", 1);
        dict.put("Y", 2);
        dict.put("Z", 3);
        try{
            dict.remove("V");
            fail("Removing an inexistent key should raise NoSuchElementException");
        } catch (NoSuchElementException e){
            grade += 0.25;
        } catch(Exception e){
            fail("Exception raised during test: " + e.toString());
        }
    }

    @Test()
    public void testRemoveX() {
        Dictionary dict = new Dictionary();
        dict.put("X", 1);
        dict.put("Y", 2);
        dict.put("Z", 3);
        dict.remove("X");
        Assert.assertFalse(dict.contains("X"));
        assertEquals(2, (int) dict.get("Y"));
        assertEquals(3, (int) dict.get("Z"));
    }

    @Test()
    public void testRemoveY() {
        Dictionary dict = new Dictionary();
        dict.put("X", 1);
        dict.put("Y", 2);
        dict.put("Z", 3);
        dict.remove("Y");
        Assert.assertFalse(dict.contains("Y"));
        assertEquals(1, (int) dict.get("X"));
        assertEquals(3, (int) dict.get("Z"));
    }

    @Test()
    public void testRemoveZ() {
        Dictionary dict = new Dictionary();
        dict.put("X", 1);
        dict.put("Y", 2);
        dict.put("Z", 3);
        dict.remove("Z");
        Assert.assertFalse(dict.contains("Z"));
        assertEquals(1, (int) dict.get("X"));
        assertEquals(2, (int) dict.get("Y"));
    }

    @Test()
    public void testRemoveXX() {
        Dictionary dict = new Dictionary();
        dict.put("X", 1);
        dict.put("Y", 2);
        dict.put("Z", 3);
        dict.put("X", 4);
        dict.remove("X");
        assertEquals(1, (int) dict.get("X"));
        assertEquals(2, (int) dict.get("Y"));
        assertEquals(3, (int) dict.get("Z"));
    }

    @Test()
    public void testRemoveYY() {
        Dictionary dict = new Dictionary();
        dict.put("X", 1);
        dict.put("Y", 2);
        dict.put("Z", 3);
        dict.put("Y", 4);
        dict.remove("Y");
        assertEquals(1, (int) dict.get("X"));
        assertEquals(2, (int) dict.get("Y"));
        assertEquals(3, (int) dict.get("Z"));
    }

    @Test()
    public void testRemoveZZ() {
        Dictionary dict = new Dictionary();
        dict.put("X", 1);
        dict.put("Y", 2);
        dict.put("Z", 3);
        dict.put("Z", 4);
        dict.remove("Z");
        assertEquals(1, (int) dict.get("X"));
        assertEquals(2, (int) dict.get("Y"));
        assertEquals(3, (int) dict.get("Z"));
    }

    @Test()
    public void testGetStatic() {
        Dictionary d1 = new Dictionary();
        Dictionary d2 = new Dictionary();
        d1.put("X", 1);
        Assert.assertFalse(d2.contains("X"));
    }
    @Test()
    public void testGetX() {
        Dictionary dict = new Dictionary();
        dict.put("X", 1);
        dict.put("Y", 2);
        dict.put("Z", 3);
        assertEquals(1, (int) dict.get("X"));
    }

    @Test()
    public void testGetY() {
        Dictionary dict = new Dictionary();
        dict.put("X", 1);
        dict.put("Y", 2);
        dict.put("Z", 3);
        assertEquals(2, (int) dict.get("Y"));
    }

    @Test()
    public void testGetZ() {
        Dictionary dict = new Dictionary();
        dict.put("X", 1);
        dict.put("Y", 2);
        dict.put("Z", 3);
        assertEquals(3, (int) dict.get("Z"));
    }

    @Test()
    public void testGetXX() {
        Dictionary dict = new Dictionary();
        dict.put("X", 1);
        dict.put("Y", 2);
        dict.put("Z", 3);
        dict.put("X", 4);
        assertEquals(4, (int) dict.get("X"));
    }

    @Test()
    public void testGetYY() {
        Dictionary dict = new Dictionary();
        dict.put("X", 1);
        dict.put("Y", 2);
        dict.put("Z", 3);
        dict.put("Y", 4);
        assertEquals(4, (int) dict.get("Y"));
    }

    @Test()
    public void testGetZZ() {
        Dictionary dict = new Dictionary();
        dict.put("X", 1);
        dict.put("Y", 2);
        dict.put("Z", 3);
        dict.put("Z", 4);
        assertEquals(4, (int) dict.get("Z"));
    }

    @Test()
    public void testReplaceX() {
        Dictionary dict = new Dictionary();
        dict.put("X", 1);
        dict.put("Y", 2);
        dict.put("Z", 3);
        dict.replace("X", 4);
        assertEquals(4, (int) dict.get("X"));
    }

    @Test()
    public void testReplaceY() {
        Dictionary dict = new Dictionary();
        dict.put("X", 1);
        dict.put("Y", 2);
        dict.put("Z", 3);
        dict.replace("Y", 4);
        assertEquals(4, (int) dict.get("Y"));
    }

    @Test()
    public void testReplaceZ() {
        Dictionary dict = new Dictionary();
        dict.put("X", 1);
        dict.put("Y", 2);
        dict.put("Z", 3);
        dict.replace("Z", 4);
        assertEquals(4, (int) dict.get("Z"));
    }

    @Test()
    public void testReplaceXX() {
        Dictionary dict = new Dictionary();
        dict.put("X", 1);
        dict.put("Y", 2);
        dict.put("Z", 3);
        dict.put("X", 4);
        dict.replace("X", 5);
        assertEquals(5, (int) dict.get("X"));
    }

    @Test()
    public void testReplaceYY() {
        Dictionary dict = new Dictionary();
        dict.put("X", 1);
        dict.put("Y", 2);
        dict.put("Z", 3);
        dict.put("Y", 4);
        dict.replace("Y", 5);
        assertEquals(5, (int) dict.get("Y"));
    }

    @Test()
    public void testReplaceZZ() {
        Dictionary dict = new Dictionary();
        dict.put("X", 1);
        dict.put("Y", 2);
        dict.put("Z", 3);
        dict.put("Z", 4);
        dict.replace("Z", 5);
        assertEquals(5, (int) dict.get("Z"));
    }

    @Test()
    public void testPutDyncamicArray() {
        Dictionary dict = new Dictionary();
        for (int i = 0; i < 1000; i++) {
            dict.put("X" + i, i);
        }
        for (int i = 0; i < 1000; i++) {
            assertEquals(i, (int) dict.get("X" + i));
        }
    }

    @Test()
    public void testContainsEmpty() {
        Dictionary dict = new Dictionary();
        Assert.assertFalse(dict.contains("X"));
    }

    @Test()
    public void testContainsNotFound() {
        Dictionary dict = new Dictionary();
        dict.put("X", 1);
        dict.put("Y", 2);
        dict.put("Z", 3);
        Assert.assertFalse(dict.contains("W"));
    }

    @Test()
    public void testContainsX() {
        Dictionary dict = new Dictionary();
        dict.put("X", 1);
        dict.put("Y", 2);
        dict.put("Z", 3);
        Assert.assertTrue(dict.contains("X"));
    }

    @Test()
    public void testContainsY() {
        Dictionary dict = new Dictionary();
        dict.put("X", 1);
        dict.put("Y", 2);
        dict.put("Z", 3);
        Assert.assertTrue(dict.contains("Y"));
    }

    @Test()
    public void testContainsZ() {
        Dictionary dict = new Dictionary();
        dict.put("X", 1);
        dict.put("Y", 2);
        dict.put("Z", 3);
        Assert.assertTrue(dict.contains("Z"));
    }

    @Test()
    public void testContainsXX() {
        Dictionary dict = new Dictionary();
        dict.put("X", 1);
        dict.put("Y", 2);
        dict.put("Z", 3);
        dict.put("X", 4);
        Assert.assertTrue(dict.contains("X"));
    }

    @Test()
    public void testContainsYY() {
        Dictionary dict = new Dictionary();
        dict.put("X", 1);
        dict.put("Y", 2);
        dict.put("Z", 3);
        dict.put("Y", 4);
        Assert.assertTrue(dict.contains("Y"));
    }

    @Test()
    public void testContainsZZ() {
        Dictionary dict = new Dictionary();
        dict.put("X", 1);
        dict.put("Y", 2);
        dict.put("Z", 3);
        dict.put("Z", 4);
        Assert.assertTrue(dict.contains("Z"));
    }

    public static void main(String[] args) {

        TestUtils.runClass(TestL7Dictionary.class);

    }
}
