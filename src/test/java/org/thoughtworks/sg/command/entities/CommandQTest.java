package org.thoughtworks.sg.command.entities;

import org.junit.Assert;
import org.junit.Test;

import static java.util.Collections.emptyList;

public class CommandQTest {

    private CommandQ commandQ;

    @Test
    public void shouldGenerateACommand() {
        commandQ = new CommandQ();
        try {
            commandQ.execute(null, emptyList());
        } catch (RuntimeException e) {
            Assert.assertEquals("QUIT", e.getMessage());
        }
    }
}
