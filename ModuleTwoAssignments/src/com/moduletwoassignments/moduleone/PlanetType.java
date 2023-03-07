package com.moduletwoassignments.moduleone;

public enum PlanetType {
    GAS("Gas"), ROCK("Rock"), ICE("Ice");

    private final String type;

    PlanetType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return type;
    }
}