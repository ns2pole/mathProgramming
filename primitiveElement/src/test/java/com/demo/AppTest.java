package com.demo;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.LinkedHashSet;
import javax.naming.directory.ModificationItem;


/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }

    /**
     * Rigourous Test :-)
     */
    public void test_product_unit_group() {
        int modInt1 = 10;
	    LinkedHashSet<ModInteger> elements = ModInteger.getElementsOfReplicativeGroup(modInt1);
	    BinaryOperator<ModInteger> op1 = ModInteger.getGraphOfUnitGroupFor(modInt1);
        System.out.println(op1);
        ModInteger m2 = new ModInteger(Integer.valueOf(2));
        GroupElement<ModInteger> ge2 = new GroupElement(m2);
        ModInteger m3 = new ModInteger(Integer.valueOf(3));
        GroupElement<ModInteger> ge3 = new GroupElement(m3);
        ModInteger m4 = new ModInteger(Integer.valueOf(4));
        GroupElement<ModInteger> ge4 = new GroupElement(m4);
        ModInteger m7 = new ModInteger(Integer.valueOf(7));
        GroupElement<ModInteger> ge7 = new GroupElement(m7);
        ModInteger m9 = new ModInteger(Integer.valueOf(9));
        GroupElement<ModInteger> ge9 = new GroupElement(m9);
        assertEquals(new ModInteger(Integer.valueOf(7)), op1.calc(m3, m9));
        assertEquals(new ModInteger(Integer.valueOf(3)), op1.calc(m7, m9));
        assertEquals(new ModInteger(Integer.valueOf(1)), op1.calc(m9, m9));
        BinaryOperator<ModInteger> op2 = new ModIntegerBinaryOperator(modInt1);
        assertEquals(new ModInteger(Integer.valueOf(7)), op2.calc(m3, m9));
        assertEquals(new ModInteger(Integer.valueOf(3)), op2.calc(m7, m9));
        assertEquals(new ModInteger(Integer.valueOf(1)), op2.calc(m9, m9));
    }
}
