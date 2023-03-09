package com.moduletwoassignments.moduletwo;

/**
 * Enumeration of predefined card suits.
 */
public enum CardSuit {
    CLUBS("Clubs"), SPADES("Spades"), HEARTS("Hearts"), DIAMONDS("Diamonds");

    private final String suit;

    CardSuit(String suit) {
        this.suit = suit;
    }

    @Override
    public String toString() {
        return suit;
    }
}