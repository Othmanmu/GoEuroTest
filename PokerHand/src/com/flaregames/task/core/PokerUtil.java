/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flaregames.task.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import static com.flaregames.task.core.Hand.Rank;

/**
 *
 * @author tms-mustafa
 */
public class PokerUtil {

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

    /**
     *
     * @param data to be checked.
     * @return array of integer contains pair of values , first is for Value
     * which has max occurrence and second of number of occurrence.
     */
    public int[] countLargestSameValues(int[] data) {

        int[] result = new int[2];
        ArrayList<Integer> list = arrayToList(data);
        int maxCount = 0;
        int current = 0;
        int maxCountValue = 0;
        boolean first = true;
        for (Integer i : list) {
            current = Collections.frequency(list, i);

            if (first) {
                maxCount = current;
                maxCountValue = i;
                first = false;
            }

            if (current > maxCount) {
                maxCount = current;
                maxCountValue = i;
            }
        }

        result[0] = maxCountValue;
        result[1] = maxCount;

        return result;
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
     * Count number of value pair in array of int.
     *
     * @param data array of int to be cheked.
     * @return number of pairs.
     */
    public int countPairs(int[] data) {
        ArrayList<Integer> list = arrayToList(data);

        int pairCount = 0;
        int current = 0;
        for (Integer i : list) {
            current = Collections.frequency(list, i);
            if (current % 2 == 0) {
                pairCount++;
            }

        }
        return pairCount / 2;
    }

    /**
     * Check highest value of pairs , for checking next high pair you can set
     * highest value in exclude parameter
     *
     * @param data array of int to be checked
     * @param excluded value to be excluded.
     * @return value of highest pair.
     */
    public int getHighestPair(int[] data, int excluded) {
        int result = -1;
        ArrayList<Integer> list = arrayToList(data);

        int current = 0;
        for (Integer i : list) {
            current = Collections.frequency(list, i);
            if (current % 2 == 0) {
                if (i > result && i != excluded) {
                    result = i;
                }
            }
        }
        return result;
    }

    /**
     * Remove the whole pair from given array
     *
     * @param data array of int to be checked.
     * @return array after removing pair.
     */
    public int[] removePair(int[] data) {
        int[] result = new int[data.length - 2];
        ArrayList<Integer> list = arrayToList(data);

        int index = 0;
        int current = 0;
        for (Integer i : list) {
            current = Collections.frequency(list, i);
            if (current % 2 == 0) {
                // don't copy pair
            } else {
                result[index] = i;
                index++;
            }
        }
        return result;
    }

    public boolean hasSameValues(int[] values, int[] values2) {
        return arrayToList(values).equals(arrayToList(values2));
    }

    /**
     * Returns largest values in given array.
     *
     * @param values
     * @return largest value in array (after sorting it).
     */
    public int getMaxValue(int[] values) {
        Arrays.sort(values);
        return values[values.length - 1];
    }

    /**
     * Compare two arrays contents and return largest value.
     *
     * @param firstValues first array of int []
     * @param secondValues second array of int []
     * @return -1 if the first array highest value is smaller that second array
     * highest value 0 if they contains same highest value. 1 if first array
     * largest element is greater than second array highest value.
     */
    public int[] compareArray(int[] firstValues, int[] secondValues) {
        int index = 4;
        int firstMax;
        int secondMax;
        int[] winner = {-1, -1, -1};

        // incase of indentical values , we have nothing to do.
        if (!hasSameValues(firstValues, secondValues)) {
            firstMax = firstValues[index];
            secondMax = secondValues[index];

            while ((firstMax == secondMax) && index > 0) {
                index--;
                firstMax = firstValues[index];
                secondMax = secondValues[index];
            }

        } else {
            winner[0] = 0;
            return winner;
        }
        winner[0] = Integer.compare(firstMax, secondMax);
        winner[1] = Integer.max(firstMax, secondMax);
        winner[2] = Integer.min(firstMax, secondMax);
        return winner;
    }

    /**
     * Compares two rank and return which of them has higher category.
     *
     * @param firstRank
     * @param secondRank
     * @return -1 if first rank have lower category than second 0 if they have
     * same rank; 1 if first rank has higher category than second rank.
     */
    public int compareRank(Rank firstRank, Rank secondRank) {
        return Integer.compare(Rank.valueOf(String.valueOf(firstRank)).ordinal(),
                Rank.valueOf(String.valueOf(secondRank)).ordinal());
    }

}
