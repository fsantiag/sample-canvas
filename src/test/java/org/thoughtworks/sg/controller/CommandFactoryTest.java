package org.thoughtworks.sg.controller;

import org.junit.Test;
import org.thoughtworks.sg.controller.commands.*;
import org.thoughtworks.sg.exceptions.CommandValidationException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CommandFactoryTest {

    @Test
    public void shouldReturnAnInstanceOfCCommand() {
        AbstractCommand command = CommandFactory.getCommand("c");
        assertTrue(command instanceof CreateCanvasCommand);
    }

    @Test
    public void shouldReturnAnInstanceOfRCommand() {
        AbstractCommand command = CommandFactory.getCommand("r");
        assertTrue(command instanceof DrawRectangleCommand);
    }

    @Test
    public void shouldReturnAnInstanceOfLCommand() {
        AbstractCommand command = CommandFactory.getCommand("l");
        assertTrue(command instanceof DrawLineCommand);
    }

    @Test
    public void shouldReturnAnInstanceOfQCommand() {
        AbstractCommand command = CommandFactory.getCommand("q");
        assertTrue(command instanceof QuitCommand);
    }

    @Test
    public void shouldReturnAnInstanceOfBCommand() {
        AbstractCommand command = CommandFactory.getCommand("b");
        assertTrue(command instanceof DrawBucketFillCommand);
    }

    @Test
    public void shouldRaiseExceptionIfAInvalidCommandTypeIsPassed() {
        boolean hasError = false;
        try {
            CommandFactory.getCommand("invalidType");
        } catch (CommandValidationException e) {
            hasError = true;
        }
        assertTrue(hasError);
    }
}
