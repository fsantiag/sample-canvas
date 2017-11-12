package org.thoughtworks.sg.command;

import org.junit.Assert;
import org.junit.Test;
import org.thoughtworks.sg.command.QuitCommand;

import static java.util.Collections.emptyList;

public class QuitCommandTest {

    private QuitCommand quitCommand;

    @Test
    public void shouldGenerateACommand() {
        quitCommand = new QuitCommand();
        try {
            quitCommand.execute(null, emptyList());
        } catch (RuntimeException e) {
            Assert.assertEquals("QUIT", e.getMessage());
        }
    }
}
