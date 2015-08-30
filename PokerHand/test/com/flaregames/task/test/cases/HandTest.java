/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flaregames.task.test.cases;

import com.flaregames.task.core.Card;
import com.flaregames.task.core.Hand;
import java.util.ArrayList;
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

        ArrayList<Card> cards = new ArrayList<Card>();
        Card card = new Card(5, "H");
        cards.add(card);
        card = new Card(3, "H");
        cards.add(card);
        card = new Card("Q", "D");
        cards.add(card);
        card = new Card(9, "S");
        cards.add(card);
        card = new Card("K", "S");
        cards.add(card);
        
        hand = new Hand(cards);

    }

    private Hand hand;

    /**
     * Test of getValues method, of class Hand.
     */
    @Test
    public void testGetValues() {
        System.out.println("getValues");
        Hand instance = hand;
        int[] expResult = {3,5,9,12,13};
        int[] result = instance.getValues();
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of getSuites method, of class Hand.
     */
    @Test
    public void testGetSuites() {
        System.out.println("getSuites");
        Hand instance = hand;
        String[] expResult = {"D", "H" , "H" , "S" , "S"};
        String[] result = instance.getSuites();
        assertArrayEquals(expResult, result);
    }

}
