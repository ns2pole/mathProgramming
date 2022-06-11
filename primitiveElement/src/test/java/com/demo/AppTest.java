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

    public void test_get_nth_power() {
        Integer tenModulo = Integer.valueOf(10);
        Integer fourteenModulo = Integer.valueOf(14);
        ModInteger m3_10 = new ModInteger(tenModulo, Integer.valueOf(3));
        assertEquals(new ModInteger(tenModulo, Integer.valueOf(3)), m3_10.getNthPower(1));
        assertEquals(new ModInteger(tenModulo, Integer.valueOf(9)), m3_10.getNthPower(2));
        assertEquals(new ModInteger(tenModulo, Integer.valueOf(7)), m3_10.getNthPower(3));
        assertEquals(new ModInteger(tenModulo, Integer.valueOf(1)), m3_10.getNthPower(4));
        ModInteger m3_14 = new ModInteger(fourteenModulo, Integer.valueOf(3));
        assertEquals(new ModInteger(fourteenModulo, Integer.valueOf(3)), m3_14.getNthPower(1));
        assertEquals(new ModInteger(fourteenModulo, Integer.valueOf(9)), m3_14.getNthPower(2));
        assertEquals(new ModInteger(fourteenModulo, Integer.valueOf(13)), m3_14.getNthPower(3));
        assertEquals(new ModInteger(fourteenModulo, Integer.valueOf(11)), m3_14.getNthPower(4));
        assertEquals(new ModInteger(fourteenModulo, Integer.valueOf(5)), m3_14.getNthPower(5));
        assertEquals(new ModInteger(fourteenModulo, Integer.valueOf(1)), m3_14.getNthPower(6));
    }

    public void test_get_order_of_element() {
        Integer tenModulo = Integer.valueOf(10);
        Integer fourteenModulo = Integer.valueOf(14);
        ModInteger m3_10 = new ModInteger(tenModulo, Integer.valueOf(3));
        assertEquals(4, m3_10.getOrder().intValue());
        ModInteger m3_14 = new ModInteger(fourteenModulo, Integer.valueOf(3));
        assertEquals(6, m3_14.getOrder().intValue());
    }

    public void test_get_order_of_irreducible_cosets_group() {
        Integer tenModulo = Integer.valueOf(10);
        IrreducibleCosetsGroup ig_10 = ModInteger.getIrreducibleCosetsGroup(tenModulo);
        assertEquals(4, ig_10.getOrder().intValue());
        Integer fourteenModulo = Integer.valueOf(14);
        IrreducibleCosetsGroup ig_14 = ModInteger.getIrreducibleCosetsGroup(fourteenModulo);
        assertEquals(6, ig_14.getOrder().intValue());
    }

    /**
     * Rigourous Test :-)
     */
    public void test_product_unit_group() {
        int modInt1 = 10;
//	    LinkedHashSet<ModInteger> elements = ModInteger.getElementsOfIrreducibleCosetsGroup(modInt1);
	    BinaryOperator<ModInteger> op1 = ModInteger.getGraphOfUnitGroupFor(modInt1);
        System.out.println(op1);
        ModInteger m2 = new ModInteger(modInt1, Integer.valueOf(2));
        GroupElement<ModInteger> ge2 = new GroupElement(m2);
        ModInteger m3 = new ModInteger(modInt1, Integer.valueOf(3));
        GroupElement<ModInteger> ge3 = new GroupElement(m3);
        ModInteger m4 = new ModInteger(modInt1, Integer.valueOf(4));
        GroupElement<ModInteger> ge4 = new GroupElement(m4);
        ModInteger m7 = new ModInteger(modInt1, Integer.valueOf(7));
        GroupElement<ModInteger> ge7 = new GroupElement(m7);
        ModInteger m9 = new ModInteger(modInt1, Integer.valueOf(9));
        GroupElement<ModInteger> ge9 = new GroupElement(m9);
        assertEquals(new ModInteger(modInt1, Integer.valueOf(7)), op1.calc(m3, m9));
        assertEquals(new ModInteger(modInt1, Integer.valueOf(3)), op1.calc(m7, m9));
        assertEquals(new ModInteger(modInt1, Integer.valueOf(1)), op1.calc(m9, m9));
        BinaryOperator<ModInteger> op2 = new ModIntegerBinaryOperator(modInt1);
        assertEquals(new ModInteger(modInt1, Integer.valueOf(7)), op2.calc(m3, m9));
        assertEquals(new ModInteger(modInt1, Integer.valueOf(3)), op2.calc(m7, m9));
        assertEquals(new ModInteger(modInt1, Integer.valueOf(1)), op2.calc(m9, m9));
    }
}
