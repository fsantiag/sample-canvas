package org.thoughtworks.sg.models.shapes;

import org.junit.Before;
import org.junit.Test;
import org.thoughtworks.sg.models.canvas.Canvas;
import org.thoughtworks.sg.models.canvas.Point;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class BucketFillTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private Canvas canvas;

    @Before
    public void setup(){
        canvas = new Canvas(10 , 20);
    }

    @Test
    public void shouldBucketFillTheCanvas() {
        System.setOut(new PrintStream(outContent));
        PrintStream oldOutputStream = System.out;

        Point p1 = new Point(2,1);
        Point p2 = new Point(7,20);

        Rectangle rectangle = new Rectangle(p1, p2);
        canvas.drawShape(rectangle);

        BucketFill bucketFill = new BucketFill(new Point(8, 9), "o");
        canvas.drawShape(bucketFill);
        canvas.render();

        String canvasFilled =
                "*--------------------*\n" +
                "|                    |\n" +
                "|xxxxxxxxxxxxxxxxxxxx|\n" +
                "|x                  x|\n" +
                "|x                  x|\n" +
                "|x                  x|\n" +
                "|x                  x|\n" +
                "|xxxxxxxxxxxxxxxxxxxx|\n" +
                "|oooooooooooooooooooo|\n" +
                "|oooooooooooooooooooo|\n" +
                "|oooooooooooooooooooo|\n" +
                "*--------------------*\n";

        assertEquals(canvasFilled, outContent.toString());
        System.setOut(oldOutputStream);
    }
}
