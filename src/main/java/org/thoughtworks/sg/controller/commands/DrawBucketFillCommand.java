package org.thoughtworks.sg.controller.commands;

import org.thoughtworks.sg.models.canvas.Canvas;
import org.thoughtworks.sg.models.canvas.Point;
import org.thoughtworks.sg.controller.AbstractCommand;
import org.thoughtworks.sg.controller.CommandType;
import org.thoughtworks.sg.exceptions.CommandValidationException;
import org.thoughtworks.sg.models.shapes.BucketFill;

import java.util.ArrayList;
import java.util.List;

public class DrawBucketFillCommand extends AbstractCommand {

    @Override
    public Canvas execute(Canvas canvas, List<String> parameters) {
        if (canvas != null) {
            List<Integer> validatedParams = this.validate(parameters, canvas);
            int i = validatedParams.get(0);
            int j = validatedParams.get(1);

            String color = parameters.get(2);

            Point start = new Point(i, j);
            BucketFill bucketFill = new BucketFill(start, color);
            canvas.drawShape(bucketFill);
            canvas.render();
        }
        return canvas;
    }

    @Override
    public List<Integer> validate(List<String> parameters, Canvas canvas) throws CommandValidationException {
        if (parameters.size() >= 3) {
            ArrayList<String> parametersCopy = new ArrayList<>(parameters);
            String color = parametersCopy.remove(2);

            if (color.length() > 1) {
                throw new CommandValidationException("The color for the '"
                        + CommandType.BUCKET.getValue() + "' commands should be one single character.");
            }

            List<Integer> parametersAsInt = super.validateAndParseParameters(parametersCopy);
            super.validateCanvasLimits(canvas, parametersAsInt);
            return parametersAsInt;
        } else {
            throw new CommandValidationException("Wrong number of arguments" +
                    " for commands '" + CommandType.BUCKET.getValue() + "'.");
        }
    }
}
