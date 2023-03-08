package com.moduletwoassignments.moduletwo;

public class FaceCard extends Card {
    CardFace name;

    FaceCard(CardFace name, CardSuit cardSuit) {
        super(name.getNumber(), cardSuit);
        this.name = name;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof FaceCard) {
            FaceCard other = (FaceCard) object;

            if (this.name == other.name && this.cardSuit == other.cardSuit) {
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