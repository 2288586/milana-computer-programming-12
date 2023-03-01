package com.moduleoneassignments.moduleone.four;

/**
 * Triangle with three sides, width, height and rotation angle in degrees.
 */
public class Triangle extends TwoDShape implements Rotate {
    double side1;
    double side2;
    double side3;

    double angle;

    public Triangle(double width, double height, Colour colour) {
        super(width, height, colour);

        //Pythagorean Theorem (Assumption: Isosceles Triangle)
        double sideLength = Math.sqrt(Math.pow(width / 2, 2) + Math.pow(height, 2));

        this.side1 = sideLength;
        this.side2 = width;
        this.side3 = sideLength;

        this.angle = 0;
    }

    public Triangle(double side1, double side2, double side3, Colour colour) {
        super(colour);

        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;

        this.width = side2;
        this.height = heronsHeight();
        this.angle = 0;
    }

    /**
     * Calculates height using Heron's Formula, assuming second side is width.
     * <blockquote><pre>
     *     Heron's Formula: Triangle Area = sqrt(s*(s-side1)*(s-side2)*(s-side3))
     *     Where s = Semi Perimeter Of Triangle</pre></blockquote>
     *
     * @return the triangle's height.
     */
    private double heronsHeight() {
        double semiPerimeter = (side1 + side2 + side3) / 2;

        //Heron's Formula
        double triangleArea = Math.sqrt(semiPerimeter * (semiPerimeter - side1) * (semiPerimeter - side2) * (semiPerimeter - side3));

        double heronsHeight = triangleArea * 2 / width;
        return heronsHeight;
    }

    /**
     * Calculates triangle area, assuming second side is width.
     * <blockquote><pre>
     *     Formula: Triangle Area = 0.5 * width * height</pre></blockquote>
     *
     * @return the triangle's area.
     */
    @Override
    public double getArea() {
        double triangleArea = width * height * 0.5;
        return triangleArea;
    }

    @Override
    public String toString() {
        return "Shape: Triangle, Side Lengths: " + side1 + ", " + side2 + ", " + side3 + ", Colour: " + colour;
    }

    /**
     * Rotates the triangle 90 degrees clockwise.
     */
    @Override
    public void rotate90() {
        rotate(90);
    }

    /**
     * Rotates the triangle 180 degrees clockwise.
     */
    @Override
    public void rotate180() {
        rotate(180);
    }

    /**
     * Rotates the triangle clockwise.
     *
     * @param angle in degrees (not radians).
     */
    @Override
    public void rotate(double angle) {
        this.angle = angle;
    }
}