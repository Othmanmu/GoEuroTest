/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flaregames.task.core;

import java.util.ArrayList;
import java.util.Collections;
import static com.flaregames.task.core.Hand.Rank;

/**
 * This is considered as master class included all needed functions used in
 * game.
 *
 * @author mustafa
 */
public class PokerManager {

    /**
     * Checks weather input values are consecutive or not.
     *
     * @param values to be checked.
     * @return
     */
    public boolean isConsecutive(int[] values) {
        int number = 0;
        for (int i = 0; i < values.length - 1; i++) {
            if (values[i] == values[i + 1] - 1) {
                number++;
            }
        }
        return number == 4;
    }

    /**
     * Checks if input suite have same value or not.
     *
     * @param suite
     * @return
     */
    public boolean isSameSuite(String[] suite) {
        int number = 0;
        for (int i = 0; i < suite.length - 1; i++) {
            if (suite[i].equals(suite[i + 1])) {
                number++;
            }
        }
        return number == 4;
    }

    public int countSameValues(int[] data, boolean maxValue) {
        ArrayList<Integer> list = arrayToList(data);
        int max = 0;
        int min = 0;
        int current = 0;
        boolean first = true;
        for (Integer i : list) {
            current = Collections.frequency(list, i);
            if (first) {
                max = min = current;
                first = false;
            }
            if (current < min) {
                min = current;
            }
            if (current > max) {
                max = current;
            }
        }
        return maxValue ? max : min;
    }

    public int countPairs(int[] data) {
        ArrayList<Integer> list = arrayToList(data);

        int pairCount = 0;
        int current = 0;
        for (Integer i : list) {
            current = Collections.frequency(list, i);
            if (current % 2 ==0) {
                pairCount++;
            }

        }
        return pairCount / 2;
    }

    /**
     * Converts array to ArrayList.
     *
     * @param values : to be converted to ArrayList
     * @return ArrayList representing values.
     */
    public ArrayList<Integer> arrayToList(int[] values) {

        ArrayList<Integer> result = new ArrayList<>();
        for (int index = 0; index < values.length; index++) {
            result.add(values[index]);
        }

        return result;
    }

    /**
     * Generate list of cards to be used in Deck.
     *
     * @return Lists of Cards
     */
    public ArrayList<Card> generateCards() {
        ArrayList<Card> cards = new ArrayList<>();
        for (int i = 0; i < suits.length; i++) {
            for (int y = 0; y < values.length; y++) {
                Card card = new Card(values[y], suits[i]);
                cards.add(card);
            }
        }
        return cards;

    }

    private Object[] values = {2, 3, 4, 5, 6, 7, 8, 9, 10, "J", "Q", "K", "A"};
    private String[] suits = {"H", "S", "D", "C"};

  

    /**
     * Calculate Rank for hand
     *
     * @param hand to be ranked
     * @return Rank.
     */
    public Rank getRank(Hand hand) {
        Hand.Rank result = Hand.Rank.HIGH_CARD;

        if (isConsecutive(hand.getValues())) {
            if (isSameSuite(hand.getSuites())) {
                return Rank.STRAIGHT_FLSUH;
            } else {
                return Rank.STRAIGHT;
            }
        }
        if (isSameSuite(hand.getSuites())) {
            return Rank.FLUSH;
        }

        int count = countSameValues(hand.getValues(), true);
        int pairCount = countPairs(hand.getValues());

        switch (count) {
            case 4:
                return Rank.FOUR_OF_KIND;

            case 3:
                if (pairCount == 1) // the remaining is pair
                {
                    return Rank.FULL_HOUSE;
                } else {
                    return Rank.THREE_OF_KIND;
                }

        }
        switch (pairCount) {
            case 1:
                return Rank.PAIR;

            case 2:
                return Rank.TWO_PAIRS;

        }
        return result;
    }

}
