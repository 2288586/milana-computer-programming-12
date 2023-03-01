package com.moduleoneassignments.moduleone.seven;

/**
 * Enumeration of predefined colours.
 */
public enum Colour {
    RED("Red"), GREEN("Green"), BLUE("Blue"), NONE("None");

    private final String colour;

    Colour(String colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        return colour;
    }
}