package com.moduleoneassignments.moduleone.one;

public class TwoDShape {
    double width;
    double height;

    public TwoDShape(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public TwoDShape() {
        this(0, 0);
    }

    public double getArea() {
        double twoDShapeArea = width * height;
        return twoDShapeArea;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}