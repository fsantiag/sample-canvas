package org.thoughtworks.sg.controller.commands;

import org.junit.Before;
import org.junit.Test;
import org.thoughtworks.sg.models.canvas.Canvas;
import org.thoughtworks.sg.controller.commands.CreateCanvasCommand;
import org.thoughtworks.sg.exceptions.CommandValidationException;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

public class CreateCanvasCommandTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private CreateCanvasCommand createCanvasCommand;

    @Before
    public void setup() {
        System.setOut(new PrintStream(outContent));
        createCanvasCommand = new CreateCanvasCommand();
    }

    @Test
    public void shouldExecuteCCommand() {
        List<String> parameters = new ArrayList<>();
        parameters.add("10");
        parameters.add("10");

        Canvas canvas = createCanvasCommand.execute(null, parameters);

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
            createCanvasCommand.execute(null, parameters);
        } catch (CommandValidationException e) {
            assertEquals("Wrong number of arguments for commands 'C'.", e.getMessage());
            hasError = true;
        }
        assertTrue(hasError);
    }
}
