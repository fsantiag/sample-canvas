package org.thoughtworks.sg.models.shapes;

import org.junit.Before;
import org.junit.Test;
import org.thoughtworks.sg.models.canvas.Canvas;
import org.thoughtworks.sg.models.canvas.Point;

import static org.junit.Assert.assertEquals;

public class LineTest {

    private Canvas canvas;

    @Before
    public void setup(){
        canvas = new Canvas(10 , 20);
    }

    @Test
    public void shouldDrawALine() {
        Point p1 = new Point(3,5);
        Point p2 = new Point(3,10);

        Line line = new Line(p1, p2);
        canvas.drawShape(line);

        for (int j = p1.getJ(); j <= p2.getJ(); j++){
            assertEquals(
                    "x",
                    canvas.getMatrix()[p1.getI()][j].getColor());
        }
    }
}
