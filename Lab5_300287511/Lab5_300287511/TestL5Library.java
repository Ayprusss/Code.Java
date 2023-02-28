import org.junit.AfterClass;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.Rule;

import static org.junit.Assert.*;

public class TestL5Library {

    @Rule
    public Timeout globalTimeout = Timeout.seconds(1); // 1 seconds max per method tested

    private static double grade = 0.0;

    @AfterClass
    public static void afterClass() {

        System.out.println(TestUtils.DIV);

        System.out.println("Grade for Library (out of a possible 2.50): " + String.format("%.2f", grade));

        System.out.println(TestUtils.DIV);

    }

    @Test
    public void testAddBook() {
      Book myBook = new Book("Shakespeare", "Hamlet", 1600);
      Library myLibrary = new Library();
      myLibrary.addBook(myBook);

      assertEquals(myBook, myLibrary.getBook(0));

      grade += 0.25;
    }


    @Test
    public void testSortByAuthor() {
      Book myBook = new Book("Shakespeare", "Hamlet", 1600);
      Book myBook2 = new Book("Ienaga", "The Pacific War", 1968);
      Library myLibrary = new Library();
      myLibrary.addBook(myBook);
      myLibrary.addBook(myBook2);
      myLibrary.sort();

      assertEquals("Library: sorting by author, first", myBook2, myLibrary.getBook(0));
      assertEquals("Library: sorting by author, second", myBook, myLibrary.getBook(1));

      grade += 0.25;
    }

    @Test
    public void testSortByAuthorSameTitleAndYear() {
      Book myBook = new Book("Shakespeare", "Hamlet", 1600);
      Book myBook2 = new Book("Author", "Hamlet", 1600);
      Library myLibrary = new Library();
      myLibrary.addBook(myBook);
      myLibrary.addBook(myBook2);
      myLibrary.sort();

      assertEquals("Library: sort by author, same title, same year, first", myBook2, myLibrary.getBook(0));
      assertEquals("Library: sort by author, same title, same year, second", myBook, myLibrary.getBook(1));

      grade += 0.25;
    }

    @Test
    public void testSortByTitleSameAuthorAndYear() {
      Book myBook = new Book("Shakespeare", "Hamlet", 1600);
      Book myBook2 = new Book("Shakespeare", "A Midsummer Night's Dream", 1600);
      Library myLibrary = new Library();
      myLibrary.addBook(myBook);
      myLibrary.addBook(myBook2);
      myLibrary.sort();

      assertEquals("Library: sort by title, same author, same year, first", myBook2, myLibrary.getBook(0));
      assertEquals("Library: sort by title, same author, same year, second", myBook, myLibrary.getBook(1));

      grade += 0.25;
    }

    @Test
    public void testSortByTitleInitialRightOrder() {
      Book myBook = new Book("Shakespeare", "Hamlet", 1600);
      Book myBook2 = new Book("Shakespeare", "A Midsummer Night's Dream", 1600);
      Library myLibrary = new Library();
      myLibrary.addBook(myBook2);
      myLibrary.addBook(myBook);
      myLibrary.sort();

      assertEquals("Library: sort by title, same author, same year, first", myBook2, myLibrary.getBook(0));
      assertEquals("Library: sort by title, same author, same year, second", myBook, myLibrary.getBook(1));

      grade += 0.25;
    }

    @Test
    public void testSortByYear() {
      Book myBook = new Book("Shakespeare", "Hamlet", 1600);
      Book myBook2 = new Book("Shakespeare", "Hamlet", 1599);
      Library myLibrary = new Library();
      myLibrary.addBook(myBook);
      myLibrary.addBook(myBook2);
      myLibrary.sort();

      assertEquals("Library: sort by year, same author, same title, first", myBook2, myLibrary.getBook(0));
      assertEquals("Library: sort by year, same author, same title, second", myBook, myLibrary.getBook(1));

      grade += 0.25;
    }

    @Test
    public void testSortNineBooks() {
      Book myBook = new Book("Shakespeare", "Hamlet", 1600);
      Book myBook2 = new Book("Shakespeare", "A Midsummer Night's Dream", 1600);
      Book myBook3 = new Book("Shakespeare", "Hamlet", 1599);
      Book myBook4 = new Book("Ienaga", "The Pacific War", 1968);
      Book myBook5 = new Book("Coutu", "Le québécois en 10 leçons", 2014);

      Library myLibrary = new Library();
      myLibrary.addBook(myBook);
      myLibrary.addBook(myBook2);
      myLibrary.addBook(myBook3);
      myLibrary.addBook(myBook4);
      myLibrary.addBook(myBook5);

      myLibrary.sort();

      assertEquals("Library: sort by author first", myBook5, myLibrary.getBook(0));
      assertEquals("Library: sort by author", myBook4, myLibrary.getBook(1));
      assertEquals("Library: sort by title", myBook2, myLibrary.getBook(2));
      assertEquals("Library: sort by year", myBook3, myLibrary.getBook(3));
      assertEquals("Library: sort last element", myBook, myLibrary.getBook(4));

      grade += 1.0;
    }


    public static void main(String[] args) {

        TestUtils.runClass(TestL5Library.class);

    }

}
