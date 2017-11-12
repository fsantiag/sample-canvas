package org.thoughtworks.sg.command;

import org.thoughtworks.sg.canvas.Canvas;
import org.thoughtworks.sg.exceptions.CommandValidationException;

import java.util.List;

public class QuitCommand extends AbstractCommand {

    @Override
    public Canvas execute(Canvas canvas, List<String> parameters) {
        System.out.println("Exiting canvas...");
        throw new CommandValidationException("QUIT");
    }

    @Override
    public List<Integer> validate(List<String> parameters, Canvas canvas) throws CommandValidationException {
        return null;
    }
}
