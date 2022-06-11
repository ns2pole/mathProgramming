package com.demo;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.util.LinkedHashSet;

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

    public void test_hash_set_equals() {
        LinkedHashSet<ModInteger> ms1 = IrreducibleCosetsGroup.getIrreducibleCosetsGroup(Integer.valueOf(10) ).elements;
        LinkedHashSet<ModInteger> ms2 = IrreducibleCosetsGroup.getIrreducibleCosetsGroup(Integer.valueOf(10) ).elements;
        LinkedHashSet<ModInteger> s = new LinkedHashSet<ModInteger>();
        Integer tenModulo = Integer.valueOf(10);
        ModInteger m1_10 = new ModInteger(tenModulo, Integer.valueOf(1));
        ModInteger m3_10 = new ModInteger(tenModulo, Integer.valueOf(3));
        ModInteger m7_10 = new ModInteger(tenModulo, Integer.valueOf(7));
        ModInteger m9_10 = new ModInteger(tenModulo, Integer.valueOf(9));
        s.add(m1_10);
        s.add(m3_10);
        s.add(m7_10);
        s.add(m9_10);
        assertEquals(ms1, ms2);
        assertEquals(ms2, s);
    }

    public void test_get_nth_power() {
        Integer tenModulo = Integer.valueOf(10);
        Integer fourteenModulo = Integer.valueOf(14);
        ModInteger m1_10 = new ModInteger(tenModulo, Integer.valueOf(1));
        ModInteger m3_10 = new ModInteger(tenModulo, Integer.valueOf(3));
        ModInteger m7_10 = new ModInteger(tenModulo, Integer.valueOf(7));
        ModInteger m9_10 = new ModInteger(tenModulo, Integer.valueOf(9));
        ModInteger m7_14 = new ModInteger(fourteenModulo, Integer.valueOf(7));
        IrreducibleCosetsGroupElement icge1_10 = new IrreducibleCosetsGroupElement(m1_10);
        IrreducibleCosetsGroupElement icge3_10 = new IrreducibleCosetsGroupElement(m3_10);
        IrreducibleCosetsGroupElement icge7_10 = new IrreducibleCosetsGroupElement(m7_10);
        IrreducibleCosetsGroupElement icge9_10 = new IrreducibleCosetsGroupElement(m9_10);
        IrreducibleCosetsGroupElement icge7_14 = new IrreducibleCosetsGroupElement(m7_14);
        assertEquals(icge3_10, icge3_10.getNthPower(1));
        assertEquals(icge9_10, icge3_10.getNthPower(2));
        assertEquals(icge7_10, icge3_10.getNthPower(3));
        assertEquals(icge1_10, icge3_10.getNthPower(4));
        assertTrue(icge3_10.equals(icge3_10.getNthPower(1)));
        assertTrue(icge9_10.equals(icge3_10.getNthPower(2)));
        assertTrue(icge7_10.equals(icge3_10.getNthPower(3)));
        assertTrue(icge1_10.equals(icge3_10.getNthPower(4)));
        assertFalse(icge1_10.equals(icge3_10.getNthPower(1)));
        assertFalse(icge1_10.equals(icge3_10.getNthPower(2)));
        assertFalse(icge1_10.equals(icge3_10.getNthPower(3)));
        assertFalse(icge7_14.equals(icge3_10.getNthPower(3)));
    }

    public void test_get_order_of_element() {
        Integer tenModulo = Integer.valueOf(10);
        Integer fourteenModulo = Integer.valueOf(14);
        ModInteger m1_10 = new ModInteger(tenModulo, Integer.valueOf(1));
        ModInteger m3_10 = new ModInteger(tenModulo, Integer.valueOf(3));
        ModInteger m7_10 = new ModInteger(tenModulo, Integer.valueOf(7));
        ModInteger m9_10 = new ModInteger(tenModulo, Integer.valueOf(9));
        ModInteger m7_14 = new ModInteger(fourteenModulo, Integer.valueOf(7));
        IrreducibleCosetsGroupElement icge1_10 = new IrreducibleCosetsGroupElement(m1_10);
        IrreducibleCosetsGroupElement icge3_10 = new IrreducibleCosetsGroupElement(m3_10);
        IrreducibleCosetsGroupElement icge7_10 = new IrreducibleCosetsGroupElement(m7_10);
        IrreducibleCosetsGroupElement icge9_10 = new IrreducibleCosetsGroupElement(m9_10);
        IrreducibleCosetsGroupElement icge7_14 = new IrreducibleCosetsGroupElement(m7_14);
        assertEquals(4, icge3_10.getOrder().intValue());
    }

    public void test_get_order_of_irreducible_cosets_group() {
        Integer tenModulo = Integer.valueOf(10);
        IrreducibleCosetsGroup ig_10 = IrreducibleCosetsGroup.getIrreducibleCosetsGroup(tenModulo);
        assertEquals(4, ig_10.getOrder().intValue());
        Integer fourteenModulo = Integer.valueOf(14);
        IrreducibleCosetsGroup ig_14 = IrreducibleCosetsGroup.getIrreducibleCosetsGroup(fourteenModulo);
        assertEquals(6, ig_14.getOrder().intValue());
    }

    /**
     * Rigourous Test :-)
     */
    public void test_product_on_irreducible_cosets_group() {
        int modInt1 = 10;
	    BinaryOperator<ModInteger> op1 = IrreducibleCosetsGroup.getGraphOfIrreducibleCosetsGroupFor(modInt1);
        ModInteger m2 = new ModInteger(modInt1, Integer.valueOf(2));
        ModInteger m3 = new ModInteger(modInt1, Integer.valueOf(3));
        ModInteger m4 = new ModInteger(modInt1, Integer.valueOf(4));
        ModInteger m7 = new ModInteger(modInt1, Integer.valueOf(7));
        ModInteger m9 = new ModInteger(modInt1, Integer.valueOf(9));
        assertEquals(new ModInteger(modInt1, Integer.valueOf(7)), op1.calc(m3, m9));
        assertEquals(new ModInteger(modInt1, Integer.valueOf(3)), op1.calc(m7, m9));
        assertEquals(new ModInteger(modInt1, Integer.valueOf(1)), op1.calc(m9, m9));
        BinaryOperator<ModInteger> op2 = new ModIntegerBinaryOperator(modInt1);
        assertEquals(new ModInteger(modInt1, Integer.valueOf(7)), op2.calc(m3, m9));
        assertEquals(new ModInteger(modInt1, Integer.valueOf(3)), op2.calc(m7, m9));
        assertEquals(new ModInteger(modInt1, Integer.valueOf(1)), op2.calc(m9, m9));
    }
}