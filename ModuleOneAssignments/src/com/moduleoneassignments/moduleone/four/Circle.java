package com.moduleoneassignments.moduleone.four;

public class Circle extends TwoDShape {
    public final double PI = Math.PI;
    private double radius;

    Circle(double radius, Colour colour) {
        super(radius * 2, radius * 2, colour);
        this.radius = radius;
    }

    public double getArea() {
        double circleArea = PI * radius * radius;
        return circleArea;
    }

    @Override
    public String toString() {
        return "Shape: Circle, Radius: " + radius + ", Colour: " + colour;
    }
}