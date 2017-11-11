package org.thoughtworks.sg.command.entities;

import org.junit.Before;
import org.junit.Test;
import org.thoughtworks.sg.command.entities.CommandC;
import org.thoughtworks.sg.core.Canvas;
import org.thoughtworks.sg.exceptions.CommandValidationException;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class CommandCTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private CommandC commandC;

    @Before
    public void setup() {
        System.setOut(new PrintStream(outContent));
        commandC = new CommandC();
    }

    @Test
    public void shouldExecuteCCommand() {
        List<String> parameters = new ArrayList<>();
        parameters.add("10");
        parameters.add("10");

        Canvas canvas = commandC.execute(null, parameters);

        assertNotEquals(null, canvas);

        String canvasString =
                "*----------*\n" +
                "|          |\n" +
                "|          |\n" +
                "|          |\n" +
                "|          |\n" +
                "|          |\n" +
                "|          |\n" +
                "|          |\n" +
                "|          |\n" +
                "|          |\n" +
                "|          |\n" +
                "*----------*\n";

        assertEquals(canvasString, outContent.toString());
    }

    @Test
    public void shouldThrowErrorWhenPassingTheWrongNumberOfArguments() {
        List<String> parameters = new ArrayList<>();
        parameters.add("1");

        boolean hasError = false;
        try {
            commandC.execute(null, parameters);
        } catch (CommandValidationException e) {
            assertEquals("Wrong number of arguments for command 'C'.", e.getMessage());
            hasError = true;
        }
        assertTrue(hasError);
    }
}
