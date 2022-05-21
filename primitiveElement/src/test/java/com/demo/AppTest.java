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

    /**
     * Rigourous Test :-)
     */
    public void test_product_unit_group() {
        int modInt1 = 10;
	    LinkedHashSet<ModInteger> elements = ModInteger.getElementsOfReplicativeGroup(modInt1);
	    Graph<ModInteger> graph = ModInteger.getGraphOfUnitGroupFor(modInt1);
        Group<ModInteger> integerUnitGroup = new Group<ModInteger>(elements, graph);
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
        System.out.println(integerUnitGroup.graph.maps.size());
        System.out.println(ge3.operateTo(ge9, integerUnitGroup.graph).val);
        assertEquals(new ModInteger(Integer.valueOf(7)), ge3.operateTo(ge9, integerUnitGroup.graph).val);
        assertEquals(new ModInteger(Integer.valueOf(3)), ge7.operateTo(ge9, integerUnitGroup.graph).val);
        assertEquals(new ModInteger(Integer.valueOf(1)), ge9.operateTo(ge9, integerUnitGroup.graph).val);
    }
}
