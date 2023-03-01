package com.moduleoneassignments.moduleone.seven;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

/**
 * Testing Strategy:<br>
 * - Testing Constructor For Invalid Input (Negative Radius, Null Colour)<br>
 * - Testing {@link Circle#getArea()} Method For Valid Edge Case Input (Zero Radius)<br>
 * - Testing {@link Circle#getArea()} Method For Valid Input (Positive Radius)
 */
public class CircleTest {

    /**
     * Tests constructor for invalid negative radius input (-1).
     */
    @Test
    public void invalidNegativeRadiusInput() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Circle(-1, Colour.NONE));
    }

    /**
     * Tests constructor for invalid not-specified colour input (null).
     */
    @Test
    public void invalidNullColourInput() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Circle(1, null);
        });
    }

    /**
     * Tests {@link Circle#getArea()} method for valid zero radius input (0).
     */
    @Test
    public void getAreaZeroRadius() {
        Circle circle = new Circle(0, Colour.NONE);
        assertEquals(0d, circle.getArea(), 0.01);
    }

    /**
     * Tests {@link Circle#getArea()} method for valid positive radius input (5).
     */
    @Test
    public void getAreaPositiveRadius() {
        Circle circle = new Circle(5, Colour.NONE);
        assertEquals(25d * Math.PI, circle.getArea(), 0.01);
    }
}