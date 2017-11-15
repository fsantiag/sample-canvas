package org.thoughtworks.sg.controller.commands;

import org.junit.Before;
import org.junit.Test;
import org.thoughtworks.sg.models.canvas.Canvas;
import org.thoughtworks.sg.controller.commands.DrawLineCommand;
import org.thoughtworks.sg.exceptions.CommandValidationException;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DrawLineCommandTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private DrawLineCommand drawLineCommand;
    private Canvas canvasOld;

    @Before
    public void setup() {
        System.setOut(new PrintStream(outContent));
        drawLineCommand = new DrawLineCommand();
        canvasOld = new Canvas(5, 20);
    }

    @Test
    public void shouldExecuteLCommand() {
        List<String> parameters = new ArrayList<>();
        parameters.add("5");
        parameters.add("3");
        parameters.add("5");
        parameters.add("10");

        Canvas canvasNew = drawLineCommand.execute(canvasOld, parameters);

        for(int j = 3; j <= 10; j++) {
            assertEquals("x", canvasNew.getMatrix()[5][j].getColor());
        }

        String lineBreak = System.getProperty("line.separator");
        String canvasString =
                "*--------------------*"+ lineBreak +
                "|                    |"+ lineBreak +
                "|                    |"+ lineBreak +
                "|                    |"+ lineBreak +
                "|                    |"+ lineBreak +
                "|  xxxxxxxx          |"+ lineBreak +
                "*--------------------*"+ lineBreak;

        assertEquals(canvasString, outContent.toString());
    }

    @Test
    public void shouldThrowErrorWhenPassingTheWrongNumberOfArguments() {
        List<String> parameters = new ArrayList<>();
        parameters.add("1");

        boolean hasError = false;
        try {
            drawLineCommand.execute(canvasOld, parameters);
        } catch (CommandValidationException e) {
            assertEquals("Wrong number of arguments for commands 'L'.", e.getMessage());
            hasError = true;
        }
        assertTrue(hasError);
    }
}
