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

public class CommandRTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private CommandR commandR;
    private Canvas canvasOld;

    @Before
    public void setup() {
        System.setOut(new PrintStream(outContent));
        commandR = new CommandR();
        canvasOld = new Canvas(10, 20);
    }

    @Test
    public void shouldExecuteRCommand() {
        List<String> parameters = new ArrayList<>();
        parameters.add("5");
        parameters.add("3");
        parameters.add("7");
        parameters.add("10");

        commandR = new CommandR();
        Canvas canvasNew = commandR.execute(canvasOld, parameters);

        for (int j = 3; j <= 10; j++){
            assertEquals(
                    "x",
                    canvasNew.getMatrix()[5][j].getColor());
            assertEquals(
                    "x",
                    canvasNew.getMatrix()[7][j].getColor());
        }

        for (int i = 5; i <= 7; i++){
            assertEquals(
                    "x",
                    canvasNew.getMatrix()[i][3].getColor());
            assertEquals(
                    "x",
                    canvasNew.getMatrix()[i][10].getColor());
        }

        String canvasString =
                "*--------------------*\n" +
                "|                    |\n" +
                "|                    |\n" +
                "|                    |\n" +
                "|                    |\n" +
                "|  xxxxxxxx          |\n" +
                "|  x      x          |\n" +
                "|  xxxxxxxx          |\n" +
                "|                    |\n" +
                "|                    |\n" +
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
            commandR.execute(canvasOld, parameters);
        } catch (CommandValidationException e) {
            assertEquals("Wrong number of arguments for command 'R'.", e.getMessage());
            hasError = true;
        }
        assertTrue(hasError);
    }
}
