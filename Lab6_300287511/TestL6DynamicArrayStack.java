import org.junit.AfterClass;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.Rule;

import static org.junit.Assert.*;

public class TestL6DynamicArrayStack {

    @Rule
    public Timeout globalTimeout = Timeout.seconds(1); // 1 seconds max per method tested

    private static double grade = 0.0;

    @AfterClass
    public static void afterClass() {

        System.out.println(TestUtils.DIV);

        System.out.println("Grade for DynamicArrayStack (out of a possible 3.0): " + grade);

        System.out.println(TestUtils.DIV);

    }

    @Test
    public void testPushDynamic24th() {
      DynamicArrayStack<Integer> myStack = new DynamicArrayStack<Integer>(25);
      for (int i = 0; i < 24; i++) {
        myStack.push(i);
      }
      assertEquals(23, (int) myStack.peek());
      assertEquals(25, (int) myStack.getCapacity());

      grade += 0.5;
    }

    @Test
    public void testPushDynamic26th() {
      DynamicArrayStack<Integer> myStack = new DynamicArrayStack<Integer>(25);
      for (int i = 0; i < 26; i++) {
        myStack.push(i);
      }
      assertEquals(25, (int) myStack.peek());
      assertEquals(50, (int) myStack.getCapacity());

      grade += 0.5;
    }

    @Test
    public void testPopDynamic1st() {
      DynamicArrayStack<Integer> myStack = new DynamicArrayStack<Integer>(0);
      assertEquals(25, (int) myStack.getCapacity());
      myStack.push(999);
      assertEquals(999, (int) myStack.pop());

      grade += 0.5;
    }

    @Test
    public void testPopDynamic26th25th() {
      DynamicArrayStack<Integer> myStack = new DynamicArrayStack<Integer>(25);
      for (int i = 0; i < 26; i++) {
        myStack.push(i);
      }
      myStack.pop();
      myStack.pop();
      assertEquals(25, (int) myStack.getCapacity());

      grade += 0.5;
    }

    @Test
    public void testClearDynamic5() {
      DynamicArrayStack<Integer> myStack = new DynamicArrayStack<Integer>(25);
      for (int i = 0; i < 5; i++) {
        myStack.push(i);
      }
      myStack.clear();
      assertEquals(true, myStack.isEmpty());
      assertEquals(25, (int) myStack.getCapacity());

      grade += 0.5;
    }

    @Test
    public void testClearDynamic100() {
      DynamicArrayStack<Integer> myStack = new DynamicArrayStack<Integer>(25);
      for (int i = 0; i < 100; i++) {
        myStack.push(i);
      }
      myStack.clear();
      assertEquals(true, myStack.isEmpty());
      assertEquals(25, (int) myStack.getCapacity());

      grade += 0.5;
    }

    public static void main(String[] args) {

        TestUtils.runClass(TestL6DynamicArrayStack.class);

    }

}
