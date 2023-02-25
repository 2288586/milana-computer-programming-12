package com.moduleoneassignments.moduleone.four;

public abstract class TwoDShape {
    double width;
    double height;
    double rotation;
    Colour colour;

    /**
     * Constructs a TwoDShape with the given width, height and colour.
     * Sets TwoDShape rotation to 0 degrees.
     *
     * @param width  shape width.
     * @param height shape height.
     * @param colour shape colour.
     */
    public TwoDShape(double width, double height, Colour colour) {
        this.width = width;
        this.height = height;
        this.rotation = 0;
        this.colour = colour;
    }

    /**
     * Constructs a TwoDShape with a width and height of 0, and no colour.
     */
    public TwoDShape() {
        this(0, 0, Colour.NONE);
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