package com.moduletwoassignments.three;

import java.util.Comparator;

/**
 * Compares the cards based on the suit of the cards in the order of {@link CardSuit} values.
 */
public class CompareByCardSuit implements Comparator<Card> {

    @Override
    public int compare(Card cardOne, Card cardTwo) {
        return cardOne.cardSuit.compareTo(cardTwo.cardSuit);
    }
}