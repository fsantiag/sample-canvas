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

public class CommandLTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private CommandL commandL;
    private Canvas canvasOld;

    @Before
    public void setup() {
        System.setOut(new PrintStream(outContent));
        commandL = new CommandL();
        canvasOld = new Canvas(5, 20);
    }

    @Test
    public void shouldExecuteLCommand() {
        List<String> parameters = new ArrayList<>();
        parameters.add("5");
        parameters.add("3");
        parameters.add("5");
        parameters.add("10");

        Canvas canvasNew = commandL.execute(canvasOld, parameters);

        for(int j = 3; j <= 10; j++) {
            assertEquals("x", canvasNew.getMatrix()[5][j].getColor());
        }

        String canvasString =
                "*--------------------*\n" +
                "|                    |\n" +
                "|                    |\n" +
                "|                    |\n" +
                "|                    |\n" +
                "|  xxxxxxxx          |\n" +
                "*--------------------*\n";

        assertEquals(canvasString, outContent.toString());
    }

    @Test
    public void shouldThrowErrorWhenPassingTheWrongNumberOfArguments() {
        List<String> parameters = new ArrayList<>();
        parameters.add("1");

        boolean hasError = false;
        try {
            commandL.execute(canvasOld, parameters);
        } catch (CommandValidationException e) {
            assertEquals("Wrong number of arguments for command 'L'.", e.getMessage());
            hasError = true;
        }
        assertTrue(hasError);
    }
}
