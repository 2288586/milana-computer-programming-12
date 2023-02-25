package com.moduleoneassignments.moduleone.four;

public class Circle extends TwoDShape {
    public final double PI = Math.PI;
    private double radius;

    /**
     * Constructs a circle with the given radius and colour. Sets circle width and circle height based on circle radius.
     *
     * @param radius circle radius.
     * @param colour circle colour.
     */
    Circle(double radius, Colour colour) {
        super(radius * 2, radius * 2, colour);
        this.radius = radius;
    }

    /**
     * Calculates and returns the area of the circle based on the circle's radius.
     *
     * @return the circle's area.
     */
    public double getArea() {
        double circleArea = PI * radius * radius;
        return circleArea;
    }

    @Override
    public String toString() {
        return "Shape: Circle, Radius: " + radius + ", Colour: " + colour;
    }
}