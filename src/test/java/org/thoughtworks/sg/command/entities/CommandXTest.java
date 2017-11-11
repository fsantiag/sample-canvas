package org.thoughtworks.sg.command.entities;

import org.junit.Before;
import org.junit.Test;
import org.thoughtworks.sg.core.Canvas;
import org.thoughtworks.sg.exceptions.CommandValidationException;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CommandXTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private CommandX commandX;
    private Canvas canvasOld;

    @Before
    public void setup() {
        System.setOut(new PrintStream(outContent));
        commandX = new CommandX();
        canvasOld = new Canvas(5, 20);
    }

    @Test
    public void shouldExecuteXCommand() {
        List<String> parameters = new ArrayList<>();
        parameters.add("3");
        parameters.add("10");

        Canvas newCanvas = commandX.execute(canvasOld, parameters);

        assertEquals(newCanvas.getMatrix()[3][11].getColor(), "x");
        assertEquals(newCanvas.getMatrix()[3][10].getColor(), "x");
        assertEquals(newCanvas.getMatrix()[3][9].getColor(), "x");
        assertEquals(newCanvas.getMatrix()[2][10].getColor(), "x");
        assertEquals(newCanvas.getMatrix()[3][10].getColor(), "x");
        assertEquals(newCanvas.getMatrix()[4][10].getColor(), "x");

        String canvasString =
                "*--------------------*\n" +
                "|                    |\n" +
                "|         x          |\n" +
                "|        xxx         |\n" +
                "|         x          |\n" +
                "|                    |\n" +
                "*--------------------*\n";

        assertEquals(canvasString, outContent.toString());
    }


    @Test
    public void shouldThrowErrorWhenPassingTheWrongNumberOfArguments() {
        List<String> parameters = new ArrayList<>();
        parameters.add("1");

        boolean hasError = false;
        try {
            commandX.execute(canvasOld, parameters);
        } catch (CommandValidationException e) {
            assertEquals("Wrong number of arguments for command 'X'.", e.getMessage());
            hasError = true;
        }
        assertTrue(hasError);
    }
}
