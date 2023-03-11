package com.moduletwoassignments.three;

import java.util.ArrayList;

/**
 * Hand of cards.
 */
public class Hand {

    private final ArrayList<Card> cards;

    Hand(ArrayList<Card> cards) {
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
        return "Hand Of " + cards.size() + " Cards:\n" + cards.toString();
    }
}