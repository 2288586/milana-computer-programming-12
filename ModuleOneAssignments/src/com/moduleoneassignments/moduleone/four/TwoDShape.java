package com.moduleoneassignments.moduleone.four;

/**
 * Base class for two-dimensional shapes.
 */
public abstract class TwoDShape {
    double width;
    double height;

    Colour colour;

    public TwoDShape(double width, double height, Colour colour) {
        this.width = width;
        this.height = height;
        this.colour = colour;
    }

    public TwoDShape(Colour colour) {
        this(0, 0, colour);
    }

    /**
     * Calculates and returns the shape's area.
     *
     * @return the shape's area.
     */
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