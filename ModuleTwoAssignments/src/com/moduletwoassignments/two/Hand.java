package com.moduletwoassignments.two;

import java.util.LinkedList;

/**
 * Hand of cards.
 */
public class Hand {

    private LinkedList<Card> cards;

    Hand(LinkedList<Card> cards) {
        this.cards = cards;
    }

    @Override
    public String toString() {
        return "Hand Of " + cards.size() + " Cards";
    }
}