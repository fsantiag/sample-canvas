package org.thoughtworks.sg.controller;

import org.thoughtworks.sg.models.canvas.Canvas;
import org.thoughtworks.sg.exceptions.CommandValidationException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractCommand {

    public abstract Canvas execute(Canvas canvas, List<String> parameters);

    public abstract List<Integer> validate(List<String> parameters, Canvas canvas) throws CommandValidationException;

    public List<Integer> validateAndParseParameters(List<String> parameters) {
        if (!parameters.isEmpty()) {
            return parameters.stream().map(parameter -> {
                try {
                    Integer value = Integer.valueOf(parameter);
                    if (value < 0) throw new NumberFormatException();
                    return value;
                } catch (NumberFormatException e) {
                    throw new CommandValidationException("This command only supports positive integers as parameters.");
                }
            }).collect(Collectors.toList());
        }
        throw new CommandValidationException("The parameters for this command are empty.");
    }

    public void validateCanvasLimits(Canvas canvas, List<Integer> parametersAsInt) {

        List<Integer> parametersCopy = new ArrayList<>(parametersAsInt);
        while (!parametersCopy.isEmpty()) {
            Integer i = parametersCopy.remove(0);
            Integer j = parametersCopy.remove(0);

            int canvasLimitI = canvas.getLines() - Canvas.CANVAS_BORDER_COMPENSATION;
            int canvasLimitJ = canvas.getColumns() - Canvas.CANVAS_BORDER_COMPENSATION;

            if (i > canvasLimitI || i < 0) {
                throw new CommandValidationException("You are trying to draw outside the Canvas.");
            }

            if (j > canvasLimitJ || j < 0) {
                throw new CommandValidationException("You are trying to draw outside the Canvas.");
            }
        }
    }

    public void validateCommandPointsOrder(List<Integer> parametersAsInt) {
        if (parametersAsInt.get(0) > parametersAsInt.get(2)
                || parametersAsInt.get(1) > parametersAsInt.get(3)) {
            throw new CommandValidationException(
                    "This command accepts two pairs of points with the following constraint:" +
                            " (i1, j1) and (i2, j2) where i1 < i2 and j1 < j2");
        }
    }
}
