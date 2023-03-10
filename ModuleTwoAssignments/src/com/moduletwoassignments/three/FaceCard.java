package com.moduletwoassignments.three;

/**
 * Face card with a name, number and suit.
 */
public class FaceCard extends Card {
    CardFace name;

    FaceCard(CardFace name, CardSuit cardSuit) {
        this(name, 10, cardSuit);
    }

    FaceCard(CardFace name, int number, CardSuit cardSuit) {
        super(number, cardSuit);

        if (name == null) {
            throw new IllegalArgumentException("Face card name cannot be null.");
        }

        this.name = name;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof FaceCard) {
            FaceCard other = (FaceCard) object;

            if (this.name == other.name && this.number == other.number && this.cardSuit == other.cardSuit) {
                return true;
            }
        }

        return false;
    }

    @Override
    public int hashCode() {
        String hashcode = name + cardSuit.toString();
        return hashcode.hashCode();
    }

    @Override
    public String toString() {
        return name + " Of " + cardSuit;
    }
}