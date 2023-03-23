import org.junit.*;
import org.junit.rules.Timeout;

import java.util.EmptyStackException;

import static org.junit.Assert.*;
/**
 *
 * @author Diana Lucaci (dluca058@uottawa.ca)
 */
public class TestL7ArrayStack {

    @Rule
    public Timeout globalTimeout = Timeout.seconds(1); // 1 seconds max per method tested

    private static double grade = 0.0;

    @AfterClass
    public static void afterClass() {

        System.out.println(TestUtils.DIV);

        System.out.println("Grade for ArrayStack (out of a possible 1.5): " + grade);

        System.out.println(TestUtils.DIV);

    }

    @Test
    public void testPeekThrowsEmptyStackException(){
        ArrayStack<String> stack = new ArrayStack<String>(10);
        try{
            stack.peek();
            fail("Peek - empty stack should raise EmptyStackException(from java.util)");
        } catch (EmptyStackException e){
          grade += 0.5;
        }
    }

    @Test
    public void testPopThrowsEmptyStackException(){
        ArrayStack<String> stack = new ArrayStack<String>(10);
        try {
            String element = stack.pop();
            fail("Poping from an empty stack should raise EmptyStackException (from java.util)");
        }catch (EmptyStackException e){
            grade += 0.5;
        }
    }

    @Test
    public void testPushThrowsFullStackException(){
        ArrayStack<String> stack = new ArrayStack<String>(0);
        try{
            stack.push("dogs");
            fail("Pop element from an empty stack should raise the custom exception FullStackException");
        }catch (FullStackException e){
            grade += 0.25;
        }
    }

    @Test
    public void testPushCapacity1ThrowsFullStackException(){
        ArrayStack<String> stack = new ArrayStack<String>(1);
        try{
            stack.push("cats");
            stack.push("dogs");
            fail("Pop element from an empty stack should raise the custom exception FullStackException");
        }catch (FullStackException e){
            grade += 0.25;
        }
    }

    public static void main(String[] args) {

        TestUtils.runClass(TestL7ArrayStack.class);

    }
}