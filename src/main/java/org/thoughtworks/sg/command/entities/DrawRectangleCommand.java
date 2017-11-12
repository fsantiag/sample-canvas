package org.thoughtworks.sg.command.entities;

import org.thoughtworks.sg.command.AbstractCommand;
import org.thoughtworks.sg.command.CommandType;
import org.thoughtworks.sg.core.Canvas;
import org.thoughtworks.sg.core.Point;
import org.thoughtworks.sg.exceptions.CommandValidationException;

import java.util.List;

public class DrawRectangleCommand extends AbstractCommand {

    @Override
    public Canvas execute(Canvas canvas, List<String> parameters) {
        if (canvas != null) {
            List<Integer> validatedParams = validate(parameters, canvas);
            int i1 = validatedParams.get(0);
            int j1 = validatedParams.get(1);

            int i2 = validatedParams.get(2);
            int j2 = validatedParams.get(3);

            Point p1 = new Point(i1, j1);
            Point p2 = new Point(i2, j2);
            canvas.drawRectangle(p1, p2);
            canvas.render();
        }
        return canvas;
    }

    public List<Integer> validate(List<String> parameters, Canvas canvas) throws CommandValidationException {
        if (parameters.size() >= 4) {
            List<Integer> parametersAsInt = super.validateAndParseParameters(parameters);
            super.validateCanvasLimits(canvas, parametersAsInt);
            super.validateCommandPointsOrder(parametersAsInt);
            return parametersAsInt;
        } else {
            throw new CommandValidationException("Wrong number of arguments" +
                    " for command '" + CommandType.RECTANGLE.getValue() + "'.");
        }
    }
}