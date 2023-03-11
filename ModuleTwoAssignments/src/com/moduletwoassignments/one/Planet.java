package com.moduletwoassignments.one;

/**
 * Planet class with designation, mass, orbit time and planet type.
 */
public class Planet {
    private String designation;
    private double massKg;
    private double orbitEarthYears;
    private PlanetType type;

    public Planet(String designation, PlanetType type) {
        if (designation == null || type == null) {
            throw new IllegalArgumentException("Both designation and type must be specified.");
        }

        this.designation = designation;
        this.type = type;
    }

    public Planet(String designation, double massKg, double orbitEarthYears, PlanetType type) {
        if (designation == null || type == null) {
            throw new IllegalArgumentException("Both designation and type must be specified.");
        }

        if (massKg <= 0) {
            throw new IllegalArgumentException("Mass must be more than zero.");
        }

        if (orbitEarthYears <= 0) {
            throw new IllegalArgumentException("Orbit must be more than zero.");
        }

        this.designation = designation;
        this.massKg = massKg;
        this.orbitEarthYears = orbitEarthYears;
        this.type = type;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Planet) {
            Planet other = (Planet) object;

            if (this.designation.equals(other.designation)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public int hashCode() {
        return designation.hashCode();
    }

    @Override
    public String toString() {
        return "Planet Designation = '" + designation + "', Planet Type = '" + type + "'";
    }
}