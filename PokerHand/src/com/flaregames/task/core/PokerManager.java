/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flaregames.task.core;

import java.util.ArrayList;
import static com.flaregames.task.core.Hand.Rank;

/**
 * This is considered as master class includes all needed functions used in
 * game.
 *
 * @author mustafa
 */
public class PokerManager {

    private PokerUtil pokerUtil = new PokerUtil();

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

        if (pokerUtil.isConsecutive(hand.getValues())) {
            if (pokerUtil.isSameSuite(hand.getSuites())) {
                return Rank.STRAIGHT_FLSUH;
            } else {
                return Rank.STRAIGHT;
            }
        }
        if (pokerUtil.isSameSuite(hand.getSuites())) {
            return Rank.FLUSH;
        }

        int count = pokerUtil.countLargestSameValues(hand.getValues())[1];
        int pairCount = pokerUtil.countPairs(hand.getValues());

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

    public int[] getWinner(Hand firstHand, Hand secondHand) {
        int[] winner = {-1, -1, -1}; // used to store both winner and rank value for each player.
        firstHand.setRank(getRank(firstHand));
        secondHand.setRank(getRank(secondHand));

        int firstHighValue;
        int secondHighValue;

        if (firstHand.getRank() == secondHand.getRank()) {
            switch (firstHand.getRank()) {
                case STRAIGHT_FLSUH:
                    firstHighValue = pokerUtil.getMaxValue(firstHand.getValues());
                    secondHighValue = pokerUtil.getMaxValue(secondHand.getValues());
                    winner[0] = Integer.compare(firstHighValue, secondHighValue);
                    winner[1] = Integer.max(firstHighValue, secondHighValue);
                    winner[2] = Integer.min(firstHighValue, secondHighValue);
                    return winner;

                case FOUR_OF_KIND:
                    firstHighValue = pokerUtil.countLargestSameValues(firstHand.getValues())[0];
                    secondHighValue = pokerUtil.countLargestSameValues(secondHand.getValues())[0];
                    winner[0] = Integer.compare(firstHighValue, secondHighValue);
                    winner[1] = Integer.max(firstHighValue, secondHighValue);
                    winner[2] = Integer.min(firstHighValue, secondHighValue);
                    return winner;

                case FULL_HOUSE:
                    firstHighValue = pokerUtil.countLargestSameValues(firstHand.getValues())[0];
                    secondHighValue = pokerUtil.countLargestSameValues(secondHand.getValues())[0];

                    winner[0] = Integer.compare(firstHighValue, secondHighValue);
                    winner[1] = Integer.max(firstHighValue, secondHighValue);
                    winner[2] = Integer.min(firstHighValue, secondHighValue);
                    return winner;

                case FLUSH:

                    winner[0] = pokerUtil.compareArray(firstHand.getValues(), secondHand.getValues())[0];
                    winner[1] = pokerUtil.compareArray(firstHand.getValues(), secondHand.getValues())[1];
                    winner[2] = pokerUtil.compareArray(firstHand.getValues(), secondHand.getValues())[2];

                    return winner;

                case STRAIGHT:
                    firstHighValue = pokerUtil.getMaxValue(firstHand.getValues());
                    secondHighValue = pokerUtil.getMaxValue(secondHand.getValues());

                    winner[0] = Integer.compare(firstHighValue, secondHighValue);
                    winner[1] = Integer.max(firstHighValue, secondHighValue);
                    winner[2] = Integer.min(firstHighValue, secondHighValue);
                    return winner;

                case THREE_OF_KIND:
                    firstHighValue = pokerUtil.countLargestSameValues(firstHand.getValues())[0];
                    secondHighValue = pokerUtil.countLargestSameValues(secondHand.getValues())[0];

                    winner[0] = Integer.compare(firstHighValue, secondHighValue);
                    winner[1] = Integer.max(firstHighValue, secondHighValue);
                    winner[2] = Integer.min(firstHighValue, secondHighValue);
                    return winner;

                case TWO_PAIRS:
                    firstHighValue = pokerUtil.getHighestPair(firstHand.getValues(), -1);
                    secondHighValue = pokerUtil.getHighestPair(secondHand.getValues(), -1);
                    if (firstHighValue == secondHighValue) {
                        firstHighValue = pokerUtil.getHighestPair(firstHand.getValues(), firstHighValue);
                        secondHighValue = pokerUtil.getHighestPair(secondHand.getValues(), secondHighValue);
                    }

                    winner[0] = Integer.compare(firstHighValue, secondHighValue);
                    winner[1] = Integer.max(firstHighValue, secondHighValue);
                    winner[2] = Integer.min(firstHighValue, secondHighValue);
                    return winner;

                case PAIR:
                    firstHighValue = pokerUtil.getHighestPair(firstHand.getValues(), -1);
                    secondHighValue = pokerUtil.getHighestPair(secondHand.getValues(), -1);
                    if (firstHighValue == secondHighValue) {
                        int[] firstRemainingValues = pokerUtil.removePair(firstHand.getValues());
                        int[] secondRemainingValues = pokerUtil.removePair(secondHand.getValues());

                        firstHighValue = pokerUtil.getMaxValue(firstRemainingValues);
                        secondHighValue = pokerUtil.getMaxValue(secondRemainingValues);
                    }
                    winner[0] = Integer.compare(firstHighValue, secondHighValue);
                    winner[1] = Integer.max(firstHighValue, secondHighValue);
                    winner[2] = Integer.min(firstHighValue, secondHighValue);
                    return winner;

                case HIGH_CARD:

                    winner[0] = pokerUtil.compareArray(firstHand.getValues(), secondHand.getValues())[0];
                    winner[1] = pokerUtil.compareArray(firstHand.getValues(), secondHand.getValues())[1];
                    winner[2] = pokerUtil.compareArray(firstHand.getValues(), secondHand.getValues())[2];
                    return winner;

            }
        } else {
            winner[0] = pokerUtil.compareRank(firstHand.getRank(), secondHand.getRank());
            return winner;
        }
        return winner;
    }

}
