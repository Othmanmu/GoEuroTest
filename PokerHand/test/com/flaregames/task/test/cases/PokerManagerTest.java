/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flaregames.task.test.cases;

import com.flaregames.task.core.Card;
import com.flaregames.task.core.Hand;
import com.flaregames.task.core.PokerManager;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tms-mustafa
 */
public class PokerManagerTest {

    public PokerManagerTest() {
    }

    @Before
    public void setUp() {
    }

    /**
     * Test of isConsecutive method, of class PokerManager.
     */
    @Test
    public void testIsConsecutive() {
        System.out.println("isConsecutive");
        int[] values = {6, 7, 8, 9, 10};
        PokerManager instance = new PokerManager();
        boolean expResult = true;
        boolean result = instance.isConsecutive(values);
        assertEquals(expResult, result);

        int[] reversedValues = {6, 5, 4, 3, 2};
        expResult = false;
        result = instance.isConsecutive(reversedValues);
        result = instance.isConsecutive(reversedValues);
        result = instance.isConsecutive(reversedValues);
        assertEquals(expResult, result);

        int[] randomValues = {2, 3, 8, 2, 1};

        expResult = false;
        result = instance.isConsecutive(randomValues);
        assertEquals(expResult, result);

    }

    /**
     * Test of isSameSuite method, of class PokerManager.
     */
    @Test
    public void testIsSameSuite() {
        System.out.println("isSameSuite");
        String[] suite = {"C", "C", "C", "C", "C"};
        PokerManager instance = new PokerManager();
        boolean expResult = true;
        boolean result = instance.isSameSuite(suite);
        assertEquals(expResult, result);

        String[] otherSuite = {"C", "D", "C", "C", "C"};
        expResult = false;
        result = instance.isSameSuite(otherSuite);
        assertEquals(expResult, result);

        String[] newSuite = {"C", "C", "C", "C", "D"};
        expResult = false;
        result = instance.isSameSuite(otherSuite);
        assertEquals(expResult, result);

    }

    /**
     * Test of countSameValues method, of class PokerManager.
     */
    @Test
    public void testCountSameValues() {
        System.out.println("testCountSameValues");
        int[] values = {1, 6, 9, 3, 4};
        PokerManager instance = new PokerManager();

        int result = instance.countSameValues(values, true);
        assertEquals(1, result);

        int[] twoValues = {1, 1, 9, 3, 4};
        result = instance.countSameValues(twoValues, true);
        assertEquals(2, result);

        int[] threeValues = {1, 1, 9, 3, 1};
        result = instance.countSameValues(threeValues, true);
        assertEquals(3, result);

        int[] fourValues = {1, 1, 1, 3, 1};
        result = instance.countSameValues(fourValues, true);
        assertEquals(4, result);
    }

    /**
     * Test of countPairs method, of class PokerManager.
     */
    @Test
    public void testCountPairs() {
        System.out.println("testCountPairs");
        int[] values = {1, 6, 9, 3, 4};
        PokerManager instance = new PokerManager();

        int result = instance.countPairs(values);
        assertEquals(0, result);

        int[] oneValues = {1, 6, 9, 1, 4};

        result = instance.countPairs(oneValues);
        assertEquals(1, result);

        int[] oneFakeValues = {1, 1, 9, 1, 4};

        result = instance.countPairs(oneFakeValues);
        assertEquals(0, result);
        
        int[] twoValues = {1, 1, 9, 1, 1};

        result = instance.countPairs(twoValues);
        assertEquals(2, result);

    }

    /**
     * Test of generateCards method, of class PokerManager.
     */
    @Test
    public void testGenerateCards() {
        System.out.println("generateCards");
        PokerManager instance = new PokerManager();

        ArrayList<Card> result = instance.generateCards();
        // check number of generated cards.
        assertEquals(52, result.size());

        // check duplicate cards.
        Set<Card> set = new HashSet<Card>(result);
        assertEquals(set.size(), result.size());

    }

    /**
     * Test of getRank method, of class PokerManager.
     */
    @Test
    public void testGetStarightFlushRank() {
        System.out.println("testGetStarightFlushRank");

        ArrayList<Card> handCards = new ArrayList<>();

        Card card = new Card(5, "C");
        handCards.add(card);
        card = new Card(6, "C");
        handCards.add(card);
        card = new Card(7, "C");
        handCards.add(card);
        card = new Card(8, "C");
        handCards.add(card);
        card = new Card(9, "C");
        handCards.add(card);

        Hand hand = new Hand(handCards);
        PokerManager instance = new PokerManager();
        Hand.Rank expResult = Hand.Rank.STRAIGHT_FLSUH;

        Hand.Rank result = instance.getRank(hand);
        assertEquals(expResult, result);

    }

    /**
     * Test of getRank method, of class PokerManager.
     */
    @Test
    public void testGetStarightRank() {
        System.out.println("testGetStarightRank");

        ArrayList<Card> handCards = new ArrayList<>();

        Card card = new Card(5, "C");
        handCards.add(card);
        card = new Card(6, "D");
        handCards.add(card);
        card = new Card(7, "C");
        handCards.add(card);
        card = new Card(8, "C");
        handCards.add(card);
        card = new Card(9, "C");
        handCards.add(card);

        Hand hand = new Hand(handCards);
        PokerManager instance = new PokerManager();
        Hand.Rank expResult = Hand.Rank.STRAIGHT;

        Hand.Rank result = instance.getRank(hand);
        assertEquals(expResult, result);

    }

    /**
     * Test of getRank method, of class PokerManager.
     */
    @Test
    public void testGetFlushRank() {
        System.out.println("testGetFlushRank");

        ArrayList<Card> handCards = new ArrayList<>();

        Card card = new Card(5, "C");
        handCards.add(card);
        card = new Card(9, "C");
        handCards.add(card);
        card = new Card(7, "C");
        handCards.add(card);
        card = new Card(11, "C");
        handCards.add(card);
        card = new Card(9, "C");
        handCards.add(card);

        Hand hand = new Hand(handCards);
        PokerManager instance = new PokerManager();
        Hand.Rank expResult = Hand.Rank.FLUSH;

        Hand.Rank result = instance.getRank(hand);
        assertEquals(expResult, result);

    }

    /**
     * Test of getRank method, of class PokerManager.
     */
    @Test
    public void testGetFourOfKindRank() {
        System.out.println("testGetFourOfKindRank");

        ArrayList<Card> handCards = new ArrayList<>();

        Card card = new Card(9, "C");
        handCards.add(card);
        card = new Card(9, "H");
        handCards.add(card);
        card = new Card(7, "D");
        handCards.add(card);
        card = new Card(9, "C");
        handCards.add(card);
        card = new Card(9, "C");
        handCards.add(card);

        Hand hand = new Hand(handCards);
        PokerManager instance = new PokerManager();
        Hand.Rank expResult = Hand.Rank.FOUR_OF_KIND;

        Hand.Rank result = instance.getRank(hand);
        assertEquals(expResult, result);

    }

    /**
     * Test of getRank method, of class PokerManager.
     */
    @Test
    public void testGetThreeOfKindRank() {
        System.out.println("testGetThreeOfKindRank");

        ArrayList<Card> handCards = new ArrayList<>();

        Card card = new Card(4, "C");
        handCards.add(card);
        card = new Card(9, "H");
        handCards.add(card);
        card = new Card(7, "D");
        handCards.add(card);
        card = new Card(4, "C");
        handCards.add(card);
        card = new Card(4, "S");
        handCards.add(card);

        Hand hand = new Hand(handCards);
        PokerManager instance = new PokerManager();
        Hand.Rank expResult = Hand.Rank.THREE_OF_KIND;

        Hand.Rank result = instance.getRank(hand);
        assertEquals(expResult, result);

    }

    /**
     * Test of getRank method, of class PokerManager.
     */
    @Test
    public void testGetFullHouseRank() {
        System.out.println("testGetFullHouseRank");

        ArrayList<Card> handCards = new ArrayList<>();

        Card card = new Card(4, "C");
        handCards.add(card);
        card = new Card(9, "H");
        handCards.add(card);
        card = new Card(9, "D");
        handCards.add(card);
        card = new Card(4, "C");
        handCards.add(card);
        card = new Card(4, "S");
        handCards.add(card);

        Hand hand = new Hand(handCards);
        PokerManager instance = new PokerManager();
        Hand.Rank expResult = Hand.Rank.FULL_HOUSE;

        Hand.Rank result = instance.getRank(hand);
        assertEquals(expResult, result);

    }

    /**
     * Test of getRank method, of class PokerManager.
     */
    @Test
    public void testGetOnePairRank() {
        System.out.println("testGetOnePairRank");

        ArrayList<Card> handCards = new ArrayList<>();

        Card card = new Card(4, "C");
        handCards.add(card);
        card = new Card(9, "H");
        handCards.add(card);
        card = new Card(9, "D");
        handCards.add(card);
        card = new Card(6, "C");
        handCards.add(card);
        card = new Card(2, "S");
        handCards.add(card);

        Hand hand = new Hand(handCards);
        PokerManager instance = new PokerManager();
        Hand.Rank expResult = Hand.Rank.PAIR;

        Hand.Rank result = instance.getRank(hand);
        assertEquals(expResult, result);

    }

    /**
     * Test of getRank method, of class PokerManager.
     */
    @Test
    public void testGetTwoPairsRank() {
        System.out.println("testGetTwoPairsRank");

        ArrayList<Card> handCards = new ArrayList<>();

        Card card = new Card(2, "C");
        handCards.add(card);
        card = new Card(9, "H");
        handCards.add(card);
        card = new Card(9, "D");
        handCards.add(card);
        card = new Card(6, "C");
        handCards.add(card);
        card = new Card(2, "S");
        handCards.add(card);

        Hand hand = new Hand(handCards);
        PokerManager instance = new PokerManager();
        Hand.Rank expResult = Hand.Rank.TWO_PAIRS;

        Hand.Rank result = instance.getRank(hand);
        assertEquals(expResult, result);

    }

    /**
     * Test of getRank method, of class PokerManager.
     */
    @Test
    public void testGetHighCardRank() {
        System.out.println("testGetTwoPairsRank");

        ArrayList<Card> handCards = new ArrayList<>();

        Card card = new Card(2, "C");
        handCards.add(card);
        card = new Card(8, "H");
        handCards.add(card);
        card = new Card(10, "D");
        handCards.add(card);
        card = new Card(6, "C");
        handCards.add(card);
        card = new Card(3, "S");
        handCards.add(card);

        Hand hand = new Hand(handCards);
        PokerManager instance = new PokerManager();
        Hand.Rank expResult = Hand.Rank.HIGH_CARD;

        Hand.Rank result = instance.getRank(hand);
        assertEquals(expResult, result);

    }

}
