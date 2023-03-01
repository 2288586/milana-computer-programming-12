package com.moduleoneassignments.moduleone.two;

public class Triangle extends TwoDShape {
    double side1;
    double side2;
    double side3;

    public Triangle(double width, double height) {
        super(width, height);

        //Pythagorean Theorem (Assumption: Isosceles Triangle)
        double sideLength = Math.sqrt(Math.pow(width / 2, 2) + Math.pow(height, 2));

        this.side1 = sideLength;
        this.side2 = width;
        this.side3 = sideLength;
    }

    public Triangle(double side1, double side2, double side3) {
        validateDimension(side1);
        validateDimension(side2);
        validateDimension(side3);

        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;

        this.width = side2;
        this.height = heronsHeight();
    }

    private double heronsHeight() {
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
}