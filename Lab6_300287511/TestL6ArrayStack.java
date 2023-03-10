import org.junit.AfterClass;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.Rule;

import static org.junit.Assert.*;

public class TestL6ArrayStack {

    @Rule
    public Timeout globalTimeout = Timeout.seconds(1); // 1 seconds max per method tested

    private static double grade = 0.0;

    @AfterClass
    public static void afterClass() {

        System.out.println(TestUtils.DIV);

        System.out.println("Grade for ArrayStack (out of a possible 1.0): " + grade);

        System.out.println(TestUtils.DIV);

    }

    @Test
    public void testClearEmptyStack() {
      ArrayStack<Integer> myStack = new ArrayStack<Integer>(5);
      assertTrue("Uninitialized Stack should be empty", myStack.isEmpty());
      myStack.clear();
      assertTrue("A cleared stack should be empty", myStack.isEmpty());

      grade += 0.5;
    }

    @Test
    public void testClearPopulatedStack() {
      ArrayStack<Integer> myStack = new ArrayStack<Integer>(5);
      myStack.push(1);
      myStack.push(2);
      myStack.push(3);
      assertFalse("Non empty array should not be empty", myStack.isEmpty());
      myStack.clear();
      assertTrue("Stack should be empty after a clear call", myStack.isEmpty());

      grade += 0.5;
    }

    public static void main(String[] args) {

        TestUtils.runClass(TestL6ArrayStack.class);

    }

}
