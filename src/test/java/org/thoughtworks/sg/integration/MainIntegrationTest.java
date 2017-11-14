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
        String canvasOutput =
                "*** Welcome to Sample Canvas! ***\n" +
                "Enter the command: \n" +
                "*----------------------------------------*\n" +
                "|                                        |\n" +
                "|                                        |\n" +
                "|                                        |\n" +
                "|                                        |\n" +
                "|                                        |\n" +
                "*----------------------------------------*\n" +
                "Enter the command: \n" +
                "*----------------------------------------*\n" +
                "|                                        |\n" +
                "|    xxxxxxxxxxxxxxxxxxxxxxxxxx          |\n" +
                "|                                        |\n" +
                "|                                        |\n" +
                "|                                        |\n" +
                "*----------------------------------------*\n" +
                "Enter the command: \n" +
                "*----------------------------------------*\n" +
                "|                                        |\n" +
                "|    xxxxxxxxxxxxxxxxxxxxxxxxxx          |\n" +
                "|       xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx|\n" +
                "|       x                               x|\n" +
                "|       xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx|\n" +
                "*----------------------------------------*\n" +
                "Enter the command: \n" +
                "*----------------------------------------*\n" +
                "|                                        |\n" +
                "|    xxxxxxxxxxxxxxxxxxxxxxxxxx          |\n" +
                "|       xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx|\n" +
                "|       xooooooooooooooooooooooooooooooox|\n" +
                "|       xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx|\n" +
                "*----------------------------------------*\n" +
                "Enter the command: \n" +
                "Error: Invalid commands.\n" +
                "Enter the command: \n" +
                "Error: Wrong number of arguments for commands 'C'.\n" +
                "Enter the command: \n" +
                "Error: Wrong number of arguments for commands 'L'.\n" +
                "Enter the command: \n" +
                "Error: Wrong number of arguments for commands 'B'.\n" +
                "Enter the command: \n" +
                "Error: Wrong number of arguments for commands 'R'.\n" +
                "Enter the command: \n" +
                "Error: This command accepts two pairs of points with the " +
                "following constraint: (i1, j1) and (i2, j2) where i1 < i2 and j1 < j2\n" +
                "Enter the command: \n" +
                "Exiting models...\n";

        Assert.assertEquals(canvasOutput, outContent.toString());
    }
}
