package com.moduleoneassignments.moduleone.four;

public abstract class TwoDShape {
    double width;
    double height;
    double rotation;
    Colour colour;

    public TwoDShape(double width, double height, Colour colour) {
        this.width = width;
        this.height = height;
        this.rotation = 0;
        this.colour = colour;
    }

    public TwoDShape() {
        this(0, 0, Colour.NONE);
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