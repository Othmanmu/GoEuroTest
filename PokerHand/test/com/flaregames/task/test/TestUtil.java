/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flaregames.task.test;

import com.flaregames.task.core.Card;
import java.util.ArrayList;
import java.util.List;

/**
 * Used as testing utility class that generates different types of cards.
 *
 * @author tms-mustafa
 */
public class TestUtil {

    /**
     *
     * @return List of High Card Cards.
     */
    public List<Card> getHighCard() {
        ArrayList<Card> result = new ArrayList<>();
        Card card = new Card(4, "C");
        result.add(card);
        card = new Card(8, "C");
        result.add(card);
        card = new Card(3, "D");
        result.add(card);
        card = new Card("A", "S");
        result.add(card);
        card = new Card(6, "C");
        result.add(card);
        return result;
    }

    /**
     *
     * @return List of One Pair Cards.
     */
    public List<Card> getPairCard() {
        ArrayList<Card> result = new ArrayList<>();
        Card card = new Card(4, "C");
        result.add(card);
        card = new Card(8, "C");
        result.add(card);
        card = new Card(4, "D");
        result.add(card);
        card = new Card("A", "S");
        result.add(card);
        card = new Card(6, "C");
        result.add(card);
        return result;
    }

    /**
     *
     * @return List of Two Pairs Hand Cards.
     */
    public List<Card> getTwoPairsCard() {
        ArrayList<Card> result = new ArrayList<>();
        Card card = new Card(4, "C");
        result.add(card);
        card = new Card(8, "C");
        result.add(card);
        card = new Card(4, "D");
        result.add(card);
        card = new Card("A", "S");
        result.add(card);
        card = new Card(8, "C");
        result.add(card);
        return result;
    }

    /**
     *
     * @return List of Three of Kind Hand Cards.
     */
    public List<Card> getThreeOfKind() {
        ArrayList<Card> result = new ArrayList<>();
        Card card = new Card(4, "C");
        result.add(card);
        card = new Card(4, "C");
        result.add(card);
        card = new Card(4, "D");
        result.add(card);
        card = new Card("A", "S");
        result.add(card);
        card = new Card(8, "C");
        result.add(card);
        return result;
    }

    /**
     *
     * @return List of Straight Hand Cards.
     */
    public List<Card> getStraightCard() {
        ArrayList<Card> result = new ArrayList<>();
        Card card = new Card(4, "C");
        result.add(card);
        card = new Card(5, "C");
        result.add(card);
        card = new Card(3, "D");
        result.add(card);
        card = new Card(7, "S");
        result.add(card);
        card = new Card(6, "C");
        result.add(card);
        return result;
    }

    /**
     *
     * @return List of Flush Hand Cards.
     */
    public List<Card> getFlushCard() {
        ArrayList<Card> result = new ArrayList<>();
        Card card = new Card(4, "C");
        result.add(card);
        card = new Card(5, "C");
        result.add(card);
        card = new Card(9, "C");
        result.add(card);
        card = new Card("A", "C");
        result.add(card);
        card = new Card(2, "C");
        result.add(card);
        return result;
    }

    /**
     *
     * @return List of Full Hand Cards.
     */
    public List<Card> getFullHouse() {
        ArrayList<Card> result = new ArrayList<>();
        Card card = new Card(4, "C");
        result.add(card);
        card = new Card(4, "C");
        result.add(card);
        card = new Card(3, "H");
        result.add(card);
        card = new Card(3, "D");
        result.add(card);
        card = new Card(3, "C");
        result.add(card);
        return result;
    }

    /**
     *
     * @return List of Four of Kind Hand Cards.
     */
    public List<Card> getFourOfKind() {
        ArrayList<Card> result = new ArrayList<>();
        Card card = new Card(4, "C");
        result.add(card);
        card = new Card(4, "C");
        result.add(card);
        card = new Card(4, "H");
        result.add(card);
        card = new Card(4, "D");
        result.add(card);
        card = new Card(3, "C");
        result.add(card);
        return result;
    }

    /**
     * 
     * @return List of Straight Flush Hand Cards.
     */
    public List<Card> getStraightFlush() {
        ArrayList<Card> result = new ArrayList<>();
        Card card = new Card(7, "C");
        result.add(card);
        card = new Card(4, "C");
        result.add(card);
        card = new Card(5, "C");
        result.add(card);
        card = new Card(6, "C");
        result.add(card);
        card = new Card(3, "C");
        result.add(card);
        return result;
    }
}
