package com.moduletwoassignments.moduletwo;

public class NumberCard extends Card {

    NumberCard(int number, CardSuit cardSuit) {
        super(number, cardSuit);
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