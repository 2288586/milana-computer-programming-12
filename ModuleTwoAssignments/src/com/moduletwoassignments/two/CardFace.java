package com.moduletwoassignments.two;

/**
 * Enumeration of predefined card faces.
 */
public enum CardFace {
    JACK("Jack"), QUEEN("Queen"), KING("King");

    private final String name;

    CardFace(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}