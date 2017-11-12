package org.thoughtworks.sg.command.entities;

import org.junit.Assert;
import org.junit.Test;

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
