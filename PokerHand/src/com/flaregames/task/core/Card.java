/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.flaregames.task.core;

/**
 *
 * @author mustafa
 *
 * Represents Card , each card has value and suite Values may by :
 * 2,3,4,5,6,7,8,9,10, Jack , Queen King and Ace.
 */
public class Card {

    private final int value;
    private final String suite;

    /**
     *
     * @param v Object represents card value , it accepts both String for values
     * : Jack , Queen King and Ace , or Integer from 2 to 10
     * @param s String name of suite , it can be (C)ube , (H)art , (D)iamond and
     * (S)pades.
     */
    public Card(Object v, String s) {
        this.value = valueToNumber(v);
        this.suite = s;
    }

    /**
     *
     * @return Integer represents card value.
     */
    public int getValue() {
        return value;
    }

    public String getSuite() {
        return suite;
    }

    @Override
    public String toString() {
        return value + " - " + suite;
    }

    /**
     * This method is used to convert card value to integer value
     *
     * @param value Value to be converted to Integer representation.
     * @return integer value corresponding to parameter value.
     */
    private int valueToNumber(Object value) {
        int result = 0;
        if (value instanceof Integer) {
            result = Integer.valueOf(value.toString());
        } else {
            switch (value.toString()) {
                case "A":
                    result = 14;
                    break;
                case "K":
                    result = 13;
                    break;
                case "Q":
                    result = 12;
                    break;
                case "J":
                    result = 11;
                    break;
            }
        }
        return result;
    }

}
