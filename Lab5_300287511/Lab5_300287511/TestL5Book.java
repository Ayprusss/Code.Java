import org.junit.AfterClass;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.Rule;

import static org.junit.Assert.*;

public class TestL5Book {

    @Rule
    public Timeout globalTimeout = Timeout.seconds(1); // 1 seconds max per method tested

    private static double grade = 0.0;

    @AfterClass
    public static void afterClass() {

        System.out.println(TestUtils.DIV);

        System.out.println("Grade for Book (out of a possible 3.50): " + String.format("%.2f", grade));

        System.out.println(TestUtils.DIV);

    }

    @Test
    public void testConstructor() {
      Book myBook = new Book("Shakespeare", "Hamlet", 1600);

      assertEquals("Shakespeare", myBook.getAuthor());
      assertEquals("Hamlet", myBook.getTitle());
      assertEquals(1600, myBook.getYear());

      grade += 0.25;
    }

    @Test
    public void testEqualBooks() {
      String a1 = new String("Shakespeare");
      String a2 = new String("Shakespeare");
      String t1 = new String("Hamlet");
      String t2 = new String("Hamlet");

      Book myBook = new Book(a1, t1, 1600);
      assertTrue("Basic equality, should work even with wrong reference comparison",
          myBook.equals(myBook));
      Book myBook2 = new Book(a2, t2, 1600);
      assertTrue("Compared references with .equals", myBook.equals(myBook2));

      grade += 0.25;
    }

    @Test
    public void testNotEqualBooksDifferentTitle() {
      Book myBook = new Book("Shakespeare", "Hamlet", 1600);
      Book myBook2 = new Book("Shakespeare", "Macbeth", 1600);
      assertFalse("Book.equals: Different titles", myBook.equals(myBook2));

      grade += 0.10;
    }

    @Test
    public void testNotEqualBooksDifferentYears() {
      Book myBook = new Book("Shakespeare", "Hamlet", 1600);
      Book myBook2 = new Book("Shakespeare", "Hamlet", 1601);
      assertFalse("Book.equals: Different years", myBook.equals(myBook2));

      grade += 0.10;
    }

    @Test
    public void testNotEqualBooksDifferentAuthor() {
      Book myBook = new Book("Shakespeare", "Hamlet", 1600);
      Book myBook2 = new Book("Shakespeared", "Hamlet", 1600);
      assertFalse("Book.equals: Different authors", myBook.equals(myBook2));

      grade += 0.10;
    }


    @Test
    public void testNotEqualNullBooks() {
      try{
        Book myBook = new Book("Shakespeare", "Hamlet", 1600);
        assertFalse("Book.equals: null parameter", myBook.equals(null));

        grade += 0.50;
      } catch(NullPointerException e) {
        fail("Book.equals: NullPointerException with null parameter");
      }
    }

    @Test
    public void testNotEqualNullAuthorParameter() {
      Book myBook = new Book("Shakespeare", "Hamlet", 1600);
      Book myBook2 = new Book(null, "Macbeth", 1600);
      assertFalse("Book.equals: null author parameter", myBook.equals(myBook2));

      grade += 0.10;
    }

    @Test
    public void testNotEqualNullAuthorInstance() {
      Book myBook = new Book("Shakespeare", "Hamlet", 1600);
      Book myBook2 = new Book(null, "Macbeth", 1600);
      assertFalse("Book.equals: null author instance", myBook2.equals(myBook));

      grade += 0.10;
    }

    @Test
    public void testEqualNullAuthors() {
      Book myBook = new Book(null, "Macbeth", 1600);
      Book myBook2 = new Book(null, "Macbeth", 1600);
      assertTrue("Book.equals: both null authors", myBook.equals(myBook2));

      grade += 0.20;
    }

    @Test
    public void testNotEqualNullTitleParameter() {
      Book myBook = new Book("Shakespeare", "Hamlet", 1600);
      Book myBook2 = new Book("Shakespeare", null, 1600);
      assertFalse("Book.equals: null title parameter", myBook.equals(myBook2));

      grade += 0.10;
    }

    @Test
    public void testNotEqualNullTitleInstance() {
      Book myBook = new Book("Shakespeare", "Hamlet", 1600);
      Book myBook2 = new Book("Shakespeare", null, 1600);
      assertFalse("Book.equals: null title instance", myBook2.equals(myBook));

      grade += 0.10;
    }

    @Test
    public void testEqualNullAuthor() {
      Book myBook = new Book(null, "Hamlet", 1600);
      Book myBook2 = new Book(null, "Hamlet", 1600);
      assertTrue("Book.equals: both null author", myBook.equals(myBook2));

      grade += 0.10;
    }

    @Test
    public void testEqualNullTitle() {
      Book myBook = new Book("Shakespeare", null, 1600);
      Book myBook2 = new Book("Shakespeare", null, 1600);
      assertTrue("Book.equals: both null title", myBook.equals(myBook2));

      grade += 0.25;
    }

    @Test
    public void testEqualWrongType() {
      Book myBook = new Book("Shakespeare", null, 1600);
      Integer myInt = Integer.valueOf(5);
      assertFalse("Book.equals: called with Integer", myBook.equals(myInt));

      grade += 0.25;
    }

    @Test
    public void testEqualNotOveritten() {
      Book myBook = new Book("Shakespeare", null, 1600);
      Book myBook2 = new Book("Shakespeare", null, 1600);
      assertTrue("Book.equals: method was overloaded and not overwritten", 
        myBook.equals((Object)myBook2));

      grade += 1.0;
    }

    public static void main(String[] args) {

        TestUtils.runClass(TestL5Book.class);

    }

}
