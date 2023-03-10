package com.moduletwoassignments.three;

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
    public boolean equals(Object object) {
        if (object instanceof Hand) {
            Hand other = (Hand) object;

            if (this.cards == other.cards) {
                return true;
            }
        }

        return false;
    }

    @Override
    public int hashCode() {
        int hashCode = cards.hashCode();
        return hashCode;
    }

    @Override
    public String toString() {
        return "Hand Of " + cards.size() + " Cards";
    }
}