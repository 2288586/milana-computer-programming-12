package com.moduletwoassignments.two;

/**
 * Base class for cards.
 */
public abstract class Card {
    int number;
    CardSuit cardSuit;

    Card(int number, CardSuit cardSuit) {
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