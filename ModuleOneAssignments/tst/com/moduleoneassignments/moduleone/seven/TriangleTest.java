package com.moduleoneassignments.moduleone.seven;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

/**
 * Testing Strategy:<br>
 * - Testing Constructors For Invalid Input (Negative Dimensions, Null Colour, Invalid Shape)<br>
 * - Testing {@link Triangle#getArea()} Method For Valid Edge Case Input (Zero Dimensions, SideX = SideY + SideZ)<br>
 * - Testing {@link Triangle#getArea()} Method For Valid Input (Positive Dimensions, Valid Shape)
 */
public class TriangleTest {

    /**
     * Tests width and height constructor for invalid negative width input (-1).
     */
    @Test
    public void invalidNegativeWidthInput() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Triangle(-1, 1, Colour.NONE));
    }

    /**
     * Tests width and height constructor for invalid negative height input (-1).
     */
    @Test
    public void invalidNegativeHeightInput() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Triangle(1, -1, Colour.NONE));
    }

    /**
     * Tests side length constructor for invalid negative side1 input (-1).
     */
    @Test
    public void invalidNegativeSideOneInput() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Triangle(-1, 1, 1, Colour.NONE));
    }

    /**
     * Tests side length constructor for invalid negative side2 input (-1).
     */
    @Test
    public void invalidNegativeSideTwoInput() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Triangle(1, -1, 1, Colour.NONE));
    }

    /**
     * Tests side length constructor for invalid negative side3 input (-1).
     */
    @Test
    public void invalidNegativeSideThreeInput() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Triangle(1, 1, -1, Colour.NONE));
    }

    /**
     * Tests width and height constructor for invalid not-specified colour input (null).
     */
    @Test
    public void invalidNullColourInputInWidthAndHeightConstructor() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Triangle(1, 1, null));
    }

    /**
     * Tests side length constructor for invalid not-specified colour input (null).
     */
    @Test
    public void invalidNullColourInputInSideLengthConstructor() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Triangle(1, 1, 1, null));
    }

    /**
     * Tests side length constructor for invalid set of side lengths (3, 1, 1).
     */
    @Test
    public void invalidSideOneTriangleShape() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Triangle(3, 1, 1, Colour.NONE));
    }

    /**
     * Tests side length constructor for invalid set of side lengths (1, 3, 1).
     */
    @Test
    public void invalidSideTwoTriangleShape() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Triangle(1, 3, 1, Colour.NONE));
    }

    /**
     * Tests side length constructor for invalid set of side lengths (1, 1, 3).
     */
    @Test
    public void invalidSideThreeTriangleShape() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Triangle(1, 1, 3, Colour.NONE));
    }

    /**
     * Tests {@link Triangle#getArea()} method for valid zero width input (0).
     */
    @Test
    public void getAreaZeroWidthInWidthAndHeightConstructor() {
        Triangle triangle = new Triangle(0, 1, Colour.NONE);
        assertEquals(0d, triangle.getArea(), 0.01);
    }

    /**
     * Tests {@link Triangle#getArea()} method for valid zero height input (0).
     */
    @Test
    public void getAreaZeroHeightInWidthAndHeightConstructor() {
        Triangle triangle = new Triangle(1, 0, Colour.NONE);
        assertEquals(0d, triangle.getArea(), 0.01);
    }

    /**
     * Tests {@link Triangle#getArea()} method for valid zero width and height input (0).
     */
    @Test
    public void getAreaZeroWidthAndHeightInWidthAndHeightConstructor() {
        Triangle triangle = new Triangle(0, 0, Colour.NONE);
        assertEquals(0d, triangle.getArea(), 0.01);
    }

    /**
     * Tests {@link Triangle#getArea()} method for valid zero side1 input (0).
     */
    @Test
    public void getAreaZeroSideOneInSideLengthConstructor() {
        Triangle triangle = new Triangle(0, 1, 1, Colour.NONE);
        assertEquals(0d, triangle.getArea(), 0.01);
    }

    /**
     * Tests {@link Triangle#getArea()} method for valid zero side2 input (0).
     */
    @Test
    public void getAreaZeroSideTwoInSideLengthConstructor() {
        Triangle triangle = new Triangle(1, 0, 1, Colour.NONE);
        assertEquals(0d, triangle.getArea(), 0.01);
    }

    /**
     * Tests {@link Triangle#getArea()} method for valid zero side3 input (0).
     */
    @Test
    public void getAreaZeroSideThreeInSideLengthConstructor() {
        Triangle triangle = new Triangle(1, 1, 0, Colour.NONE);
        assertEquals(0d, triangle.getArea(), 0.01);
    }

    /**
     * Tests {@link Triangle#getArea()} method for valid zero side1, side 2 and side 3 input (0).
     */
    @Test
    public void getAreaZeroSidesInSideLengthConstructor() {
        Triangle triangle = new Triangle(0, 0, 0, Colour.NONE);
        assertEquals(0d, triangle.getArea(), 0.01);
    }

    /**
     * Tests {@link Triangle#getArea()} method for valid flat triangle side lengths (2, 1, 1).
     */
    @Test
    public void getAreaFlatSideOneTriangleShape() {
        Triangle triangle = new Triangle(2, 1, 1, Colour.NONE);
        assertEquals(0d, triangle.getArea(), 0.01);
    }

    /**
     * Tests {@link Triangle#getArea()} method for valid flat triangle side lengths (2, 1, 1).
     */
    @Test
    public void getAreaFlatSideTwoTriangleShape() {
        Triangle triangle = new Triangle(1, 2, 1, Colour.NONE);
        assertEquals(0d, triangle.getArea(), 0.01);
    }

    /**
     * Tests {@link Triangle#getArea()} method for valid flat triangle side lengths (2, 1, 1).
     */
    @Test
    public void getAreaFlatSideThreeTriangleShape() {
        Triangle triangle = new Triangle(1, 1, 2, Colour.NONE);
        assertEquals(0d, triangle.getArea(), 0.01);
    }

    /**
     * Tests {@link Triangle#getArea()} method for valid positive width (4) and height (5) input.
     */
    @Test
    public void getAreaPositiveWidthAndHeight() {
        Triangle triangle = new Triangle(4, 5, Colour.NONE);
        assertEquals(10d, triangle.getArea(), 0.01);
    }

    /**
     * Tests {@link Triangle#getArea()} method for valid positive side1 (3), side2 (4), side3 (5) input.
     */
    @Test
    public void getAreaPositiveSides() {
        Triangle triangle = new Triangle(3, 4, 5, Colour.NONE);
        assertEquals(6d, triangle.getArea(), 0.01);
    }
}