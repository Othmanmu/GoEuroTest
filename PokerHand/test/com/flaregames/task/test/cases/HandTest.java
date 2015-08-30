/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flaregames.task.test.cases;

import com.flaregames.task.core.Hand;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tms-mustafa
 */
public class HandTest {
    
    public HandTest() {
    }
    
    @Before
    public void setUp() {
    }

     

    /**
     * Test of getValues method, of class Hand.
     */
    @Test
    public void testGetValues() {
        System.out.println("getValues");
        Hand instance = null;
        int[] expResult = null;
        int[] result = instance.getValues();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSuites method, of class Hand.
     */
    @Test
    public void testGetSuites() {
        System.out.println("getSuites");
        Hand instance = null;
        String[] expResult = null;
        String[] result = instance.getSuites();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    
}
