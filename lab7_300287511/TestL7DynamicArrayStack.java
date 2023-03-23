import org.junit.*;
import org.junit.rules.Timeout;

import java.util.EmptyStackException;

import static org.junit.Assert.*;
/**
 *
 * @author Diana Lucaci (dluca058@uottawa.ca)
 */
public class TestL7DynamicArrayStack {

    @Rule
    public Timeout globalTimeout = Timeout.seconds(1); // 1 seconds max per method tested

    private static double grade = 0.0;

    @AfterClass
    public static void afterClass() {

        System.out.println(TestUtils.DIV);

        System.out.println("Grade for DynamicArrayStack (out of a possible 1.5): " + grade);

        System.out.println(TestUtils.DIV);

    }

    @Test
    public void testPeekThrowsEmptyStackException(){
        DynamicArrayStack<String> stack = new DynamicArrayStack<String>(10);
        try{
            stack.peek();
            fail("Peek - empty stack should raise EmptyStackException(from java.util)");
        } catch (EmptyStackException e){
            grade += 0.75;
        }
    }

    @Test
    public void testPopThrowsEmptyStackException(){
        DynamicArrayStack<String> stack = new DynamicArrayStack<String>(10);
        try {
            String element = stack.pop();
            fail("Poping from an empty stack should raise EmptyStackException (from java.util)");
        }catch (EmptyStackException e){
            grade += 0.75;
        }
    }

    public static void main(String[] args) {

        TestUtils.runClass(TestL7DynamicArrayStack.class);

    }
}