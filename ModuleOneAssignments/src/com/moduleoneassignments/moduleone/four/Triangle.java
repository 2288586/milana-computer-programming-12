package com.moduleoneassignments.moduleone.four;

public class Triangle extends TwoDShape implements Rotate {
    double side1;
    double side2;
    double side3;

    public Triangle(double width, double height, Colour colour) {
        super(width, height, colour);

        //Pythagorean Theorem (Assumption: Isosceles Triangle)
        double sideLength = Math.sqrt(Math.pow(width / 2, 2) + Math.pow(height, 2));

        side1 = sideLength;
        side2 = width;
        side3 = sideLength;
    }

    public Triangle(double side1, double side2, double side3, Colour colour) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;

        this.width = side2;
        this.height = heronsHeight();
        this.colour = colour;
    }

    private double heronsHeight() {
        double triangleArea = getArea();
        double heronsHeight = 2d * triangleArea / side2;

        return heronsHeight;
    }

    @Override
    public double getArea() {
        double semiPerimeter = (side1 + side2 + side3) / 2d;

        //Heron's Formula
        double triangleArea = Math.sqrt(semiPerimeter * (semiPerimeter - side1) * (semiPerimeter - side2) * (semiPerimeter - side3));

        return triangleArea;
    }

    @Override
    public String toString() {
        return "Shape: Triangle, Side Lengths: " + side1 + ", " + side2 + ", " + side3 + ", Colour: " + colour;
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
        rotation = degree;
    }
}