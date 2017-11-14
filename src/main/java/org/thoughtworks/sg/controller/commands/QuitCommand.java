package org.thoughtworks.sg.controller.commands;

import org.thoughtworks.sg.models.canvas.Canvas;
import org.thoughtworks.sg.controller.AbstractCommand;
import org.thoughtworks.sg.exceptions.CommandValidationException;

import java.util.List;

public class QuitCommand extends AbstractCommand {

    @Override
    public Canvas execute(Canvas canvas, List<String> parameters) {
        System.out.println("Exiting models...");
        throw new CommandValidationException("QUIT");
    }

    @Override
    public List<Integer> validate(List<String> parameters, Canvas canvas) throws CommandValidationException {
        return null;
    }
}
