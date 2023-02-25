package com.moduleoneassignments.moduleone.four;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<TwoDShape> shapes = new ArrayList<>();

        shapes.add(new Triangle(4, 5, 6, Colour.RED));
        shapes.add(new Triangle(4, 5, Colour.GREEN));

        shapes.add(new Circle(1, Colour.BLUE));
        shapes.add(new Circle(2, Colour.NONE));

        for (TwoDShape shape : shapes) {
            System.out.println(shape);
            System.out.println("Area: " + shape.getArea() + "\n");
        }
    }
}