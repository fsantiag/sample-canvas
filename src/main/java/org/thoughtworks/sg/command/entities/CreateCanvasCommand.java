package org.thoughtworks.sg.command.entities;

import org.thoughtworks.sg.command.AbstractCommand;
import org.thoughtworks.sg.command.CommandType;
import org.thoughtworks.sg.core.Canvas;
import org.thoughtworks.sg.exceptions.CommandValidationException;

import java.util.List;

public class CreateCanvasCommand extends AbstractCommand {

    @Override
    public Canvas execute(Canvas canvas, List<String> parameters) {
        List<Integer> validatedParams = this.validate(parameters, canvas);
        int columns = validatedParams.get(0);
        int lines =validatedParams.get(1);
        canvas = new Canvas(columns, lines);
        canvas.render();
        return canvas;
    }

    @Override
    public List<Integer> validate(List<String> parameters, Canvas canvas) throws CommandValidationException {
        if (parameters.size() >= 2) {
            return super.validateAndParseParameters(parameters);
        } else {
            throw new CommandValidationException("Wrong number of arguments" +
                    " for command '" + CommandType.CREATE.getValue() + "'.");
        }
    }
}
