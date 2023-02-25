package com.moduleoneassignments.moduleone.four;

public class Triangle extends TwoDShape implements Rotate {
    double side1;
    double side2;
    double side3;

    /**
     * Constructs a triangle with the given width, height and colour.
     * Calculates side length, assuming triangle is isosceles and second side is width.
     *
     * @param width  triangle width.
     * @param height triangle height.
     * @param colour triangle colour.
     */
    public Triangle(double width, double height, Colour colour) {
        super(width, height, colour);

        //Pythagorean Theorem (Assumption: Isosceles Triangle)
        double sideLength = Math.sqrt(Math.pow(width / 2, 2) + Math.pow(height, 2));

        this.side1 = sideLength;
        this.side2 = width;
        this.side3 = sideLength;
    }

    /**
     * Constructs a triangle with the given side lengths and colour.
     * Assumes width is second side. Calculates height using {@link #heronsHeight()}.
     *
     * @param side1  triangle side.
     * @param side2  triangle width.
     * @param side3  triangle side.
     * @param colour triangle colour.
     */
    public Triangle(double side1, double side2, double side3, Colour colour) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;

        this.width = side2;
        this.height = heronsHeight();
        this.colour = colour;
    }

    /**
     * Calculates height using triangle area, assuming second side is width.
     * Triangle area is calculated using {@link #getArea()}.
     * <blockquote><pre>
     *     Triangle Height = Triangle Area*2/Triangle Width</pre></blockquote>
     *
     * @return the triangle's height.
     */
    private double heronsHeight() {
        double triangleArea = getArea();
        double heronsHeight = triangleArea * 2 / side2;

        return heronsHeight;
    }

    /**
     * Calculates area using Heron's Formula.
     * <blockquote><pre>
     *     Heron's Formula: Triangle Area = sqrt(s*(s-side1)*(s-side2)*(s-side3))
     *     Where s = Semi Perimeter Of Triangle</pre></blockquote>
     *
     * @return the triangle's area.
     */
    @Override
    public double getArea() {
        double semiPerimeter = (side1 + side2 + side3) / 2;

        //Heron's Formula
        double triangleArea = Math.sqrt(semiPerimeter * (semiPerimeter - side1) * (semiPerimeter - side2) * (semiPerimeter - side3));

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
     * @param degree in degrees (not radians).
     */
    @Override
    public void rotate(double degree) {
        rotation = degree;
    }
}