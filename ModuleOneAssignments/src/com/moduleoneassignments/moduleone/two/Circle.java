package com.moduleoneassignments.moduleone.two;

public class Circle extends TwoDShape {
    public final double PI = Math.PI;
    private double radius;

    Circle(double radius) {
        super(radius * 2, radius * 2);
        this.radius = radius;
    }

    public double getArea() {
        double circleArea = PI * radius * radius;
        return circleArea;
    }

    @Override
    public String toString() {
        return "Shape: Circle, Radius: " + radius;
    }
}