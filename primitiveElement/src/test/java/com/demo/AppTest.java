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
	    LinkedHashSet<IntegerUnitGroupElement> elements = IntegerUnitGroup.getElementsOfReplicativeGroup(modInt1);
	    Graph<IntegerUnitGroupElement> graph = IntegerUnitGroup.getGraphOfUnitGroupFor(modInt1);
        IntegerUnitGroup integerUnitGroup = new IntegerUnitGroup(elements, graph);
        IntegerUnitGroupElement e2 = integerUnitGroup.getElementHas(Integer.valueOf(2));
        IntegerUnitGroupElement e3 = integerUnitGroup.getElementHas(Integer.valueOf(3));
        IntegerUnitGroupElement e4 = integerUnitGroup.getElementHas(Integer.valueOf(4));
        IntegerUnitGroupElement e7 = integerUnitGroup.getElementHas(Integer.valueOf(7));
        IntegerUnitGroupElement e9 = integerUnitGroup.getElementHas(Integer.valueOf(9));
        assertEquals(null, e2.val);
        assertEquals(Integer.valueOf(3), e3.val);
        assertEquals(null, e4.val);
        assertEquals(Integer.valueOf(9), e9.val);
        assertEquals(Integer.valueOf(7), e3.operateTo(e9, integerUnitGroup.graph).val);
        assertEquals(Integer.valueOf(3), e7.operateTo(e9, integerUnitGroup.graph).val);
        assertEquals(Integer.valueOf(1), e9.operateTo(e9, integerUnitGroup.graph).val);

    }
}
