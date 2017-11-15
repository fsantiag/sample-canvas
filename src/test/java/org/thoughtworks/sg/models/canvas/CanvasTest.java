package org.thoughtworks.sg.models.canvas;

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
    public void shouldRenderTheCanvas() {
        String lineBreak = System.getProperty("line.separator");
        System.setOut(new PrintStream(outContent));
        String canvasString =
                "*--------------------*" + lineBreak +
                "|                    |" + lineBreak +
                "|                    |" + lineBreak +
                "|                    |" + lineBreak +
                "|                    |" + lineBreak +
                "|                    |" + lineBreak +
                "|                    |" + lineBreak +
                "|                    |" + lineBreak +
                "|                    |" + lineBreak +
                "|                    |" + lineBreak +
                "|                    |" + lineBreak +
                "*--------------------*" + lineBreak;

        canvas.render();

        assertEquals(canvasString, outContent.toString());
        System.setOut(null);
    }
}
