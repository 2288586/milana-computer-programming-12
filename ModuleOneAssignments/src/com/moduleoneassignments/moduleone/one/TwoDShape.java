package com.moduleoneassignments.moduleone.one;

public class TwoDShape {
    double width;
    double height;

    public TwoDShape(double width, double height) {
        validateDimension(width);
        validateDimension(height);

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
        validateDimension(height);
        this.height = height;
    }

    protected void validateDimension(double dimension) {
        if (dimension < 0) {
            throw new IllegalArgumentException("All shape dimensions must be greater than or equal to zero.");
        }
    }
}