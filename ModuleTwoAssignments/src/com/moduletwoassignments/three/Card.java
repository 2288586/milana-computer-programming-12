package com.moduletwoassignments.three;

/**
 * Base class for cards.
 */
public abstract class Card {
    protected final int number;
    protected final CardSuit cardSuit;

    Card(int number, CardSuit cardSuit) {
        if (number <= 0) {
            throw new IllegalArgumentException("Card number must be greater than zero.");
        }

        if (cardSuit == null) {
            throw new IllegalArgumentException("Card suit must be specified.");
        }

        this.number = number;
        this.cardSuit = cardSuit;
    }

    @Override
    public abstract boolean equals(Object object);

    @Override
    public int hashCode() {
        String hashcode = number + cardSuit.toString();
        return hashcode.hashCode();
    }

    @Override
    public String toString() {
        return number + " Of " + cardSuit;
    }
}