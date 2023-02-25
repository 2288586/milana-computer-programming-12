package com.moduleoneassignments.moduleone.three;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<TwoDShape> shapes = new ArrayList<>();

        shapes.add(new Triangle(4, 5, 6));
        shapes.add(new Triangle(4, 5));

        shapes.add(new Circle(1));
        shapes.add(new Circle(2));

        for (TwoDShape shape : shapes) {
            System.out.println(shape);
            System.out.println("Area: " + shape.getArea() + "\n");
        }
    }
}