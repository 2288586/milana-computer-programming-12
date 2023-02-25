package com.moduleoneassignments.moduleone.three;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<TwoDShape> shapes = new ArrayList<>();

        shapes.add(new Triangle(4.0, 5.0, 6.0));
        shapes.add(new Triangle(4.0, 5.0));

        shapes.add(new Circle(1.0));
        shapes.add(new Circle(2.0));

        for (TwoDShape shape : shapes) {
            System.out.println(shape);
            System.out.println("Area: " + shape.getArea() + "\n");
        }
    }
}