package org.thoughtworks.sg.command.entities;

import org.thoughtworks.sg.command.AbstractCommand;
import org.thoughtworks.sg.core.Canvas;
import org.thoughtworks.sg.core.Point;
import org.thoughtworks.sg.exceptions.CommandValidationException;

import java.util.List;

/**
 * Created by fsantiag on 09/11/17.
 */
public class CommandX extends AbstractCommand{
    @Override
    public Canvas execute(Canvas canvas, List<String> parameters) {
        List<Integer> parsedParameters = super.validateAndParseParameters(parameters);
        Integer i = parsedParameters.get(0);
        Integer j = parsedParameters.get(1);
        Point point = new Point(Integer.valueOf(i), Integer.valueOf(j));
        canvas.drawCross(point);
        canvas.render();
        return canvas;
    }

    @Override
    public List<Integer> validate(List<String> parameters, Canvas canvas) throws CommandValidationException {
        return null;
    }
}
