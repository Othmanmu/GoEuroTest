/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flaregames.task.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Represents Poker hand , composed of set of cards.
 *
 * @author mustafa
 */
public class Hand {

    private int[] values;

    private String[] suites;
    private Rank rank;

    public enum Rank {
        HIGH_CARD, PAIR, TWO_PAIRS, THREE_OF_KIND, STRAIGHT, FLUSH, FULL_HOUSE, FOUR_OF_KIND, STRAIGHT_FLSUH
    };

    /**
     *
     * @param cards List of card , they should be 5. This constructor extract
     * values and suites from cards to set them in hand.
     */
    public Hand(List<Card> cards) {
        values = new int[cards.size()];
        suites = new String[cards.size()];
        int index = 0;

        for (Card card : cards) {
            values[index] = card.getValue();
            suites[index] = card.getSuite();
            index++;
        }

        // sorting them to facilitate comparison process.
        Arrays.sort(values);
        Arrays.sort(suites);
    }

    /**
     * Used to print string values of suites / values Used for debugging
     */
    public void showMe() {
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i] + "\t");
        }

        System.out.println();
        for (int i = 0; i < suites.length; i++) {
            System.out.print(suites[i] + "\t");
        }
    }

    /**
     *
     * @return values used in ranking.
     */
    public int[] getValues() {
        return values;
    }

    /**
     *
     * @return suites used in ranking.
     */
    public String[] getSuites() {
        return suites;
    }

    /**
     *
     * @return hand rank if any
     */
    public Rank getRank() {
        return rank;
    }

    /**
     * Sets hand rank
     *
     * @param rank
     */
    public void setRank(Rank rank) {
        this.rank = rank;
    }

    /**
     *
     * @return String representation of class
     */
    @Override
    public String toString() {
        return "Values : " + values + "\tSuite : " + suites;
    }

}
