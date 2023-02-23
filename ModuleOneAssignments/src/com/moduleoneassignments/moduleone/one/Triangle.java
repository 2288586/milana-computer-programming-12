package com.moduleoneassignments.moduleone.one;

public class Triangle extends TwoDShape {
    double side1;
    double side2;
    double side3;

    public Triangle(double width, double height) {
        super(width, height);

        side1 = 0;
        side2 = 0;
        side3 = 0;
    }

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;

        width = side2;
        height = heronsHeight();
    }

    private double heronsHeight() {
        double triangleArea = getArea();
        double heronsHeight = 2d * triangleArea / side2;

        return heronsHeight;
    }

    @Override
    public double getArea() {
        double semiPerimeter = (side1 + side2 + side3) / 2d;
        double triangleArea = Math.sqrt(semiPerimeter * (semiPerimeter - side1) * (semiPerimeter - side2) * (semiPerimeter - side3));

        return triangleArea;
    }
}