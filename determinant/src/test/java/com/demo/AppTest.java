package com.demo;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import java.util.ArrayList;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
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
    // public void test_rec()
    // {
    //     ArrayList<Integer> arr = new ArrayList<Integer>();
    //     arr.add(1);
    //     arr.add(5);
    //     arr.add(3);
    //     assertEquals(1, SymmetricGroup.rec(arr));;
        // ArrayList<Integer> col1 = new ArrayList<Integer>();
        // col1.add(1);
        // col1.add(3);
        // col1.add(4);
        // ArrayList<Integer> col2 = new ArrayList<Integer>();
        // col1.add(1);
        // col1.add(3);
        // col1.add(4);
        // ArrayList<Integer> col3 = new ArrayList<Integer>();
        // col1.add(1);
        // col1.add(3);
        // col1.add(4);
        // ArrayList<ArrayList<Integer>> cols = new ArrayList<ArrayList<Integer>>();
        // Matrix m = new Matrix(cols);
        // assertEquals(1100, m.determinant());;
    // }

    /**
     * Rigourous Test :-)
     */
    public void test_determinant()
    {
        int[][] cols = {{1,3},
                        {2,3}};
        Matrix m = new Matrix(cols);
        assertEquals(-3, m.determinant());
        int[][] cols2 = {{1,3},
                        {1,3}};
        Matrix m2 = new Matrix(cols2);
        assertEquals(0, m2.determinant());
        int[][] cols3 = {{5}};
        Matrix m3 = new Matrix(cols3);
        assertEquals(5, m3.determinant());

    }

    /**
     * Rigourous Test :-)
     */
    // public void test_cycles()
    // {
    //     ArrayList<Integer> arr = new ArrayList<>();
    //     arr.add(2);
    //     arr.add(1);
    //     arr.add(3);
    //     Permutation p = new Permutation(arr);
    //     System.out.println(p.val);
    //     System.out.println(p.cycles().size());
    //     assertEquals(-1, -1);
    // }

    /**
     * Rigourous Test :-)
     */
    // public void test_getSlideCycle()
    // {
    //     ArrayList<Integer> arr = new ArrayList<>();
    //     arr.add(2);
    //     arr.add(1);
    //     arr.add(3);
    //     Cycle c = new Cycle();
    //     c.val = arr;
    //     Permutation p = new Permutation(arr);
    //     ArrayList<Integer> arr2 = new ArrayList<>();
    //     arr2.add(2);
    //     arr2.add(3);
    //     arr2.add(1);
    //     Permutation p2 = new Permutation(arr2);
    //     Cycle c2 = new Cycle();
    //     c2.val = arr2;
    //     // System.out.println(c.val);
    //     // System.out.println(c2.val);
    //     System.out.println(p.cycles().get(0).val);
    //     System.out.println(p2.cycles().get(0).val);
    //     assertEquals(-1, -1);
    // }

    /**
     * Rigourous Test :-)
     */
    // public void test_cycle()
    // {
    //     ArrayList<Integer> arr = new ArrayList<>();
    //     arr.add(2);
    //     arr.add(3);
    //     arr.add(1);
    //     Permutation p = new Permutation(arr);
    //     System.out.println(p.getMappedValRecursivelyFor(1, 3));
    //     assertEquals(-1, -1);
    // }
}
