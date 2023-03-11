package com.moduletwoassignments.three;

import java.util.Comparator;

/**
 * Compares the cards based on the numerical values of the cards from greatest to least.
 */
public class CompareByCardNumber implements Comparator<Card> {

    @Override
    public int compare(Card cardOne, Card cardTwo) {
        if (cardOne.number < cardTwo.number) {
            return 1;

        } else if (cardOne.number > cardTwo.number) {
            return -1;
        }

        return 0;
    }
}