package org.thoughtworks.sg.models.shapes;

import org.junit.Before;
import org.junit.Test;
import org.thoughtworks.sg.models.canvas.Canvas;
import org.thoughtworks.sg.models.canvas.Point;

import static org.junit.Assert.assertEquals;

public class RectangleTest {

    private Canvas canvas;

    @Before
    public void setup(){
        canvas = new Canvas(10 , 20);
    }

    @Test
    public void shouldDrawARectangle() {

        Point p1 = new Point(2,1);
        Point p2 = new Point(7,7);

        Rectangle rectangle = new Rectangle(p1, p2);
        canvas.drawShape(rectangle);

        for (int j = 1; j <= 7; j++){
            assertEquals(
                    "x",
                    canvas.getMatrix()[2][j].getColor());
            assertEquals(
                    "x",
                    canvas.getMatrix()[7][j].getColor());
        }

        for (int i = 2; i <= 7; i++){
            assertEquals(
                    "x",
                    canvas.getMatrix()[i][1].getColor());
            assertEquals(
                    "x",
                    canvas.getMatrix()[i][7].getColor());
        }
    }
}
