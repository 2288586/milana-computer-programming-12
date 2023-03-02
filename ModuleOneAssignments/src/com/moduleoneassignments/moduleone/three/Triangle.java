package com.moduleoneassignments.moduleone.three;

public class Triangle extends TwoDShape implements Rotate {
    double side1;
    double side2;
    double side3;

    double angle;

    public Triangle(double width, double height) {
        super(width, height);

        //Pythagorean Theorem (Assumption: Isosceles Triangle)
        double sideLength = Math.sqrt(Math.pow(width / 2, 2) + Math.pow(height, 2));

        this.side1 = sideLength;
        this.side2 = width;
        this.side3 = sideLength;

        this.angle = 0;
    }

    public Triangle(double side1, double side2, double side3) {
        validateDimension(side1);
        validateDimension(side2);
        validateDimension(side3);

        validateTriangleSides(side1, side2, side3);

        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;

        this.width = side2;
        this.height = heronsHeight();

        this.angle = 0;
    }

    private double heronsHeight() {
        //If Width Is Zero, side1 = side3 = height
        if (width == 0) {
            return side1;
        }

        double semiPerimeter = (side1 + side2 + side3) / 2;

        //Heron's Formula
        double triangleArea = Math.sqrt(semiPerimeter * (semiPerimeter - side1) * (semiPerimeter - side2) * (semiPerimeter - side3));

        double heronsHeight = triangleArea * 2 / width;
        return heronsHeight;
    }

    @Override
    public double getArea() {
        double triangleArea = width * height * 0.5;
        return triangleArea;
    }

    @Override
    public String toString() {
        return "Shape: Triangle, Side Lengths: " + side1 + ", " + side2 + ", " + side3;
    }

    @Override
    public void rotate90() {
        rotate(90);
    }

    @Override
    public void rotate180() {
        rotate(180);
    }

    @Override
    public void rotate(double degree) {
        this.angle = degree;
    }

    private void validateTriangleSides(double side1, double side2, double side3) {
        if (side1 > side2 + side3 || side2 > side1 + side3 || side3 > side1 + side2) {
            throw new IllegalArgumentException("One side of a triangle cannot be bigger than the other two sides combined.");
        }
    }
}