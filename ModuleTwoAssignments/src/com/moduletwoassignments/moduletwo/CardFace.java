package com.moduletwoassignments.moduletwo;

public enum CardFace {
    JACK("Jack", 11), QUEEN("Queen", 12), KING("King", 13);

    private final String name;
    private int number;

    CardFace(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return name;
    }
}