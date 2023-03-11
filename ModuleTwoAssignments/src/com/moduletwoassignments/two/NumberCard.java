package com.moduletwoassignments.two;

/**
 * Number card with a number and suit.
 */
public class NumberCard extends Card {

    NumberCard(int number, CardSuit cardSuit) {
        super(number, cardSuit);

        if (number > 10) {
            throw new IllegalArgumentException("Card number must be less than or equal to ten.");
        }
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof NumberCard) {
            NumberCard other = (NumberCard) object;

            if (this.number == other.number && this.cardSuit == other.cardSuit) {
                return true;
            }
        }

        return false;
    }
}