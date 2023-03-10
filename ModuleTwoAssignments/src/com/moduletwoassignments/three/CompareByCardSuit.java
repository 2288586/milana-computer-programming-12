package com.moduletwoassignments.three;

import java.util.Comparator;

/**
 * Compares the cards based on the suit of the cards.
 * Cards are sorted in the following order: Spades, Hearts, Clubs, Diamonds.
 */
public class CompareByCardSuit implements Comparator<Card> {

    @Override
    public int compare(Card cardOne, Card cardTwo) {
        if (cardOne.cardSuit.getSortingValue() < cardTwo.cardSuit.getSortingValue()) {
            return 1;

        } else if (cardOne.cardSuit.getSortingValue() > cardTwo.cardSuit.getSortingValue()) {
            return -1;
        }

        return 0;
    }
}