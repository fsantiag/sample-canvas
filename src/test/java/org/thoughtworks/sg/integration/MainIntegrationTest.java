package org.thoughtworks.sg.integration;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.thoughtworks.sg.Main;

import java.io.*;

public class MainIntegrationTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setup() throws IOException {
        String[] args = null;
        System.setOut(new PrintStream(outContent));
        final InputStream original = System.in;
        final FileInputStream file = new FileInputStream(new File("test_file"));
        System.setIn(file);
        Main.main(args);
        System.setIn(original);
    }
    @Test
    public void testMainRoutine() throws IOException {
        String lineBreak = System.getProperty("line.separator");
        String canvasOutput =
                "*** Welcome to Sample Canvas! ***" + lineBreak +
                "Enter the command: " + lineBreak +
                "*----------------------------------------*" + lineBreak +
                "|                                        |" + lineBreak +
                "|                                        |" + lineBreak +
                "|                                        |" + lineBreak +
                "|                                        |" + lineBreak +
                "|                                        |" + lineBreak +
                "*----------------------------------------*" + lineBreak +
                "Enter the command: " + lineBreak +
                "*----------------------------------------*" + lineBreak +
                "|                                        |" + lineBreak +
                "|    xxxxxxxxxxxxxxxxxxxxxxxxxx          |" + lineBreak +
                "|                                        |" + lineBreak +
                "|                                        |" + lineBreak +
                "|                                        |" + lineBreak +
                "*----------------------------------------*" + lineBreak +
                "Enter the command: " + lineBreak +
                "*----------------------------------------*" + lineBreak +
                "|                                        |" + lineBreak +
                "|    xxxxxxxxxxxxxxxxxxxxxxxxxx          |" + lineBreak +
                "|       xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx|" + lineBreak +
                "|       x                               x|" + lineBreak +
                "|       xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx|" + lineBreak +
                "*----------------------------------------*" + lineBreak +
                "Enter the command: " + lineBreak +
                "*----------------------------------------*" + lineBreak +
                "|                                        |" + lineBreak +
                "|    xxxxxxxxxxxxxxxxxxxxxxxxxx          |" + lineBreak +
                "|       xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx|" + lineBreak +
                "|       xooooooooooooooooooooooooooooooox|" + lineBreak +
                "|       xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx|" + lineBreak +
                "*----------------------------------------*" + lineBreak +
                "Enter the command: " + lineBreak +
                "Error: Invalid commands." + lineBreak +
                "Enter the command: " + lineBreak +
                "Error: Wrong number of arguments for commands 'C'." + lineBreak +
                "Enter the command: " + lineBreak +
                "Error: Wrong number of arguments for commands 'L'." + lineBreak +
                "Enter the command: " + lineBreak +
                "Error: Wrong number of arguments for commands 'B'." + lineBreak +
                "Enter the command: " + lineBreak +
                "Error: Wrong number of arguments for commands 'R'." + lineBreak +
                "Enter the command: " + lineBreak +
                "Error: This command accepts two pairs of points with the " +
                "following constraint: (i1, j1) and (i2, j2) where i1 < i2 and j1 < j2" + lineBreak +
                "Enter the command: " + lineBreak +
                "Exiting models..." + lineBreak;

        Assert.assertEquals(canvasOutput, outContent.toString());
    }
}
