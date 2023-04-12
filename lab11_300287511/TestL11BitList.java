import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.Rule;
import java.awt.event.ActionEvent;

import static org.junit.Assert.*;

public class TestL11BitList {

    @Rule
    public Timeout globalTimeout = Timeout.seconds(1); // 1 seconds max per method tested

    private static double grade = 0.0;

    @Before
    public void setUp() {

    }

    @AfterClass
    public static void afterClass() {

        System.out.println(TestUtils.DIV);

        System.out.println("Grade for Iterative (out of a possible 2.0): " + grade);

        System.out.println(TestUtils.DIV);

    }

    @Test
    public void testBitListConstructorOneBit0() {

        BitList list = new BitList("0");
        assertEquals("Constructor with a bne bit string: 0", "0", list.toString());
        grade += 0.5;

    }


    @Test
    public void testBitListConstructorOneBit1() {

        BitList list = new BitList("1");
        assertEquals("Constructor with a one bit string: 1", "1", list.toString());
        grade += 0.5;

    }

    @Test
    public void testBitListConstructorMultipleBits() {

        BitList list = new BitList("100111");
        assertEquals("Constructor with a multiple-bit string: 100111", "100111", list.toString());
        grade += 1;

    }

    public static void main(String[] args) {

        TestUtils.runClass(TestL11BitList.class);

    }

}
