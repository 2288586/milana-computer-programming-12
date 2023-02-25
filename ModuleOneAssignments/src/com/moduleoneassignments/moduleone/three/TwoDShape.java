package com.moduleoneassignments.moduleone.three;

public abstract class TwoDShape {
    double width;
    double height;

    double rotation;

    public TwoDShape(double width, double height) {
        this.width = width;
        this.height = height;

        this.rotation = 0;
    }

    public TwoDShape() {
        this(0, 0);
    }

    public abstract double getArea();

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}