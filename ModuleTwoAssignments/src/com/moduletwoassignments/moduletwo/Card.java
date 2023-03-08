package com.moduletwoassignments.moduletwo;

public abstract class Card {
    int number;
    CardSuit cardSuit;

    Card(int number, CardSuit cardSuit) {
        this.number = number;
        this.cardSuit = cardSuit;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Card) {
            Card other = (Card) object;

            if (this.number == other.number && this.cardSuit == other.cardSuit) {
                return true;
            }
        }

        return false;
    }

    public int hashCode() {
        String hashcode = number + cardSuit.toString();
        return hashcode.hashCode();
    }

    @Override
    public String toString() {
        return number + " Of " + cardSuit;
    }
}