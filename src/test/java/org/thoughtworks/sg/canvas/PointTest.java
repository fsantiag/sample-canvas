package org.thoughtworks.sg.canvas;

import org.junit.Test;

import static org.junit.Assert.*;

public class PointTest {
    @Test
    public void shouldCreateAPointObjectWithRightValues() {
        Point point = new Point(10, 20, "c");

        assertEquals(point.getI(), 10);
        assertEquals(point.getJ(), 20);
        assertEquals(point.getColor(), "c");
    }
}
