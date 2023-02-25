package com.moduleoneassignments.moduleone.four;

public interface Rotate {
    /**
     * Rotates the object 90 degrees clockwise.
     */
    void rotate90();

    /**
     * Rotates the object 180 degrees clockwise.
     */
    void rotate180();

    /**
     * Rotates the object clockwise.
     *
     * @param degree in degrees (not radians).
     */
    void rotate(double degree);
}