package org.thoughtworks.sg.controller.commands;

import org.junit.Before;
import org.junit.Test;
import org.thoughtworks.sg.models.canvas.Canvas;
import org.thoughtworks.sg.exceptions.CommandValidationException;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DrawBucketFillCommandTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private DrawBucketFillCommand drawBucketFillCommand;

    @Before
    public void setup() {
        System.setOut(new PrintStream(outContent));
        drawBucketFillCommand = new DrawBucketFillCommand();
    }

    @Test
    public void shouldExecuteBCommand() {
        Canvas canvasOld = drawRectangleOnCanvas();

        List<String> parameters = new ArrayList<>();
        parameters.add("8");
        parameters.add("3");
        parameters.add("m");
        drawBucketFillCommand = new DrawBucketFillCommand();
        drawBucketFillCommand.execute(canvasOld, parameters);

        String lineBreak = System.getProperty("line.separator");

        String canvasString =
                "*--------------------*"+ lineBreak +
                "|                    |"+ lineBreak +
                "|                    |"+ lineBreak +
                "|                    |"+ lineBreak +
                "|                    |"+ lineBreak +
                "|  xxxxxxxx          |"+ lineBreak +
                "|  x      x          |"+ lineBreak +
                "|  xxxxxxxx          |"+ lineBreak +
                "|                    |"+ lineBreak +
                "|                    |"+ lineBreak +
                "|                    |"+ lineBreak +
                "*--------------------*"+ lineBreak +
                "*--------------------*"+ lineBreak +
                "|mmmmmmmmmmmmmmmmmmmm|"+ lineBreak +
                "|mmmmmmmmmmmmmmmmmmmm|"+ lineBreak +
                "|mmmmmmmmmmmmmmmmmmmm|"+ lineBreak +
                "|mmmmmmmmmmmmmmmmmmmm|"+ lineBreak +
                "|mmxxxxxxxxmmmmmmmmmm|"+ lineBreak +
                "|mmx      xmmmmmmmmmm|"+ lineBreak +
                "|mmxxxxxxxxmmmmmmmmmm|"+ lineBreak +
                "|mmmmmmmmmmmmmmmmmmmm|"+ lineBreak +
                "|mmmmmmmmmmmmmmmmmmmm|"+ lineBreak +
                "|mmmmmmmmmmmmmmmmmmmm|"+ lineBreak +
                "*--------------------*"+ lineBreak;

        assertEquals(canvasString, outContent.toString());
    }

    private Canvas drawRectangleOnCanvas() {
        List<String> parameters = new ArrayList<>();
        parameters.add("5");
        parameters.add("3");
        parameters.add("7");
        parameters.add("10");
        Canvas canvasOld = new Canvas(10, 20);

        return new DrawRectangleCommand().execute(canvasOld, parameters);
    }

    @Test
    public void shouldThrowErrorWhenTheColorIsInvalid() {
        List<String> parameters = new ArrayList<>();
        parameters.add("8");
        parameters.add("3");
        parameters.add("haaha");
        drawBucketFillCommand = new DrawBucketFillCommand();
        boolean hasError = false;
        Canvas canvasOld = new Canvas(10, 20);
        try {
            drawBucketFillCommand.execute(canvasOld, parameters);
        } catch (CommandValidationException e) {
            assertEquals("The color for the 'B' commands should be one single character.", e.getMessage());
            hasError = true;
        }
        assertTrue(hasError);

    }

    @Test
    public void shouldThrowErrorWhenPassingTheWrongNumberOfArguments() {
        List<String> parameters = new ArrayList<>();
        parameters.add("1");

        Canvas canvasOld = new Canvas(1, 1);

        boolean hasError = false;
        try {
            drawBucketFillCommand.execute(canvasOld, parameters);
        } catch (CommandValidationException e) {
            assertEquals("Wrong number of arguments for commands 'B'.", e.getMessage());
            hasError = true;
        }
        assertTrue(hasError);
    }
}
