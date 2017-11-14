package org.thoughtworks.sg.controller.commands;

import org.thoughtworks.sg.models.canvas.Canvas;
import org.thoughtworks.sg.models.canvas.Point;
import org.thoughtworks.sg.controller.AbstractCommand;
import org.thoughtworks.sg.controller.CommandType;
import org.thoughtworks.sg.exceptions.CommandValidationException;
import org.thoughtworks.sg.models.shapes.Rectangle;

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

            Point start = new Point(i1, j1);
            Point end = new Point(i2, j2);
            Rectangle rectangle = new Rectangle(start, end);
            canvas.drawShape(rectangle);
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
                    " for commands '" + CommandType.RECTANGLE.getValue() + "'.");
        }
    }
}
