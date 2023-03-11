package com.moduletwoassignments.three;

/**
 * Enumeration of predefined card suits in the following order: Spades, Hearts, Clubs, Diamonds.
 */
public enum CardSuit {
    SPADES("Spades"), HEARTS("Hearts"), CLUBS("Clubs"), DIAMONDS("Diamonds");

    private final String suit;

    CardSuit(String suit) {
        this.suit = suit;
    }

    @Override
    public String toString() {
        return suit;
    }
}