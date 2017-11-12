package org.thoughtworks.sg.canvas;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class CanvasTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private Canvas canvas;

    @Before
    public void setup() {
        canvas = new Canvas(10,20);
    }

    @Test
    public void shouldCreateAEmptyCanvas() {
        for (int i = 1; i < canvas.getMatrix().length - 1; i++) {
            for (int j = 1; j < canvas.getMatrix()[0].length - 1; j++) {
                assertEquals(" ", canvas.getMatrix()[i][j].getColor());
            }
        }
    }

    @Test
    public void shouldDrawALineOnCanvas() {
        Point p1 = new Point(3,5);
        Point p2 = new Point(3,10);

        canvas.drawLine(p1, p2, "-");

        for (int j = p1.getJ(); j <= p2.getJ(); j++){
            assertEquals(
                    "-",
                    canvas.getMatrix()[p1.getI()][j].getColor());
        }
    }

    @Test
    public void shouldDrawARectangle() {

        Point p1 = new Point(2,1);
        Point p2 = new Point(7,7);

        canvas.drawRectangle(p1, p2);

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

    @Test
    public void shouldBucketFillTheCanvas() {
        System.setOut(new PrintStream(outContent));
        Point p1 = new Point(2,1);
        Point p2 = new Point(7,20);
        canvas.drawRectangle(p1, p2);

        canvas.bucketFill(8, 9, "o");

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
        System.setOut(null);
    }

    @Test
    public void shouldRenderTheCanvas() {
        System.setOut(new PrintStream(outContent));
        String canvasString =
                "*--------------------*\n" +
                "|                    |\n" +
                "|                    |\n" +
                "|                    |\n" +
                "|                    |\n" +
                "|                    |\n" +
                "|                    |\n" +
                "|                    |\n" +
                "|                    |\n" +
                "|                    |\n" +
                "|                    |\n" +
                "*--------------------*\n";

        canvas.render();

        assertEquals(canvasString, outContent.toString());
        System.setOut(null);
    }
}
