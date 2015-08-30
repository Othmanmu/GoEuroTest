/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flaregames.task.test.cases;

import com.flaregames.task.core.Card;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tms-mustafa
 */
public class CardTest {

    public CardTest() {
    }

    @Before
    public void setUp() {
    }

    /**
     * Test of getValue method, of class Card.
     */
    @Test
    public void testGetValue() {
        System.out.println("getValue");
        Card instance = new Card(3, "D");
        int expResult = 3;
        int result = instance.getValue();
        assertEquals(expResult, result);
        assertNotNull(result);

        // incase that value where enter in  quote for example "5" the value will be zeor
        instance = new Card("4", "D");
        result = instance.getValue();
        assertEquals(0, result);
        assertNotNull(result);

    }

    /**
     * Test of getSuite method, of class Card.
     */
    @Test
    public void testGetSuite() {
        System.out.println("getSuite");
        Card instance = new Card(3, "H");
        String expResult = "H";
        String result = instance.getSuite();

        assertNotNull(result);
        assertEquals(expResult, result);

    }

    /**
     * Test of toString method, of class Card.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Card instance = new Card("A", "H");;
        String expResult = "14 - H";
        String result = instance.toString();
        assertEquals(expResult, result);
      
    }

}
