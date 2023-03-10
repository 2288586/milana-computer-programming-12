package com.moduletwoassignments.three;

/**
 * Enumeration of predefined card suits.
 */
public enum CardSuit {
    CLUBS("Clubs", 2), SPADES("Spades", 0), HEARTS("Hearts", 1), DIAMONDS("Diamonds", 3);

    private final String suit;
    private final int sortingValue;

    CardSuit(String suit, int sortingValue) {
        this.suit = suit;
        this.sortingValue = sortingValue;
    }

    public int getSortingValue() {
        return sortingValue;
    }

    @Override
    public String toString() {
        return suit;
    }
}