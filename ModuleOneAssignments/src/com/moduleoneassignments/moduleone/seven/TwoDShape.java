package com.moduleoneassignments.moduleone.seven;

/**
 * Base class for two-dimensional shapes.
 */
public abstract class TwoDShape {
    double width;
    double height;

    Colour colour;

    public TwoDShape(double width, double height, Colour colour) {
        validateDimension(width);
        validateDimension(height);

        if (colour == null) {
            throw new IllegalArgumentException("Colour cannot be null.");
        }

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
        validateDimension(width);
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        validateDimension(height);
        this.height = height;
    }

    /**
     * Checks if the dimension is greater than or equal to zero.
     *
     * @param dimension shape dimension.
     * @throws IllegalArgumentException if the dimension is less than zero
     */
    protected void validateDimension(double dimension) {
        if (dimension < 0) {
            throw new IllegalArgumentException("All shape dimensions must be greater than or equal to zero.");
        }
    }
}