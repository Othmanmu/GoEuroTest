/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flaregames.task.test.cases;

import com.flaregames.task.core.Card;
import com.flaregames.task.core.Deck;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tms-mustafa
 */
public class DeckTest {
    
    public DeckTest() {
    }
    
    @Before
    public void setUp() {
    }

    /**
     * Test of getCards method, of class Deck.
     */
    @Test
    public void testGetCards() {
        System.out.println("getCards");
        Deck instance = null;
        List<Card> expResult = null;
        List<Card> result = instance.getCards();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
