package org.thoughtworks.sg.command;

import org.junit.Before;
import org.junit.Test;
import org.thoughtworks.sg.core.Canvas;
import org.thoughtworks.sg.exceptions.CommandValidationException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AbstractCommandTest {

    private AbstractCommand abstractCommand;
    private Canvas canvasOld;

    @Before
    public void setup(){
        canvasOld = new Canvas(10 , 20);
        abstractCommand = new AbstractCommand() {
            @Override
            public Canvas execute(Canvas canvas, List<String> parameters) {
                return null;
            }

            @Override
            public List<Integer> validate(List<String> parameters, Canvas canvas) throws CommandValidationException {
                return null;
            }
        };
    }

    @Test
    public void shouldThrowErrorWhenTryingToDrawOutsideCanvas() {
        List<Integer> parameters = new ArrayList<>();
        parameters.add(5);
        parameters.add(3);
        parameters.add(7);
        parameters.add(21);

        boolean hasError = false;
        try {
            abstractCommand.validateCanvasLimits(canvasOld, parameters);
        } catch (CommandValidationException e) {
            assertEquals("You are trying to draw outside the Canvas.", e.getMessage());
            hasError = true;
        }
        assertTrue(hasError);
    }

    @Test
    public void shouldThrowErrorWhenPassingInvertedPointsToCommand() {
        List<Integer> parameters = new ArrayList<>();
        parameters.add(7);
        parameters.add(20);
        parameters.add(5);
        parameters.add(3);

        boolean hasError = false;
        try {
            abstractCommand.validateCommandPointsOrder(parameters);
        } catch (CommandValidationException e) {
            assertEquals("This command accepts two pairs of points with the" +
                    " following constraint: (i1, j1) and (i2, j2) where i1 < i2 and j1 < j2", e.getMessage());
            hasError = true;
        }
        assertTrue(hasError);
    }

    @Test
    public void shouldThrowErrorWhenPassingPointsThatAreNotIntegers() {
        List<String> parameters = new ArrayList<>();
        parameters.add("invalid");
        assertErrorRaised(parameters);
    }

    @Test
    public void shouldThrowErrorWhenPassingPointsThatAreNegative() {
        List<String> parameters = new ArrayList<>();
        parameters.add("-1");
        assertErrorRaised(parameters);
    }

    private void assertErrorRaised(List<String> parameters) {
        boolean hasError = false;
        try {
            abstractCommand.validateAndParseParameters(parameters);
        } catch (CommandValidationException e) {
            assertEquals("This command only supports positive integers as parameters.", e.getMessage());
            hasError = true;
        }
        assertTrue(hasError);
    }

    @Test
    public void shouldThrowErrorWhenPassingEmptyParameters() {
        boolean hasError = false;
        try {
            abstractCommand.validateAndParseParameters(emptyList());
        } catch (CommandValidationException e) {
            assertEquals("The parameters for this command are empty.", e.getMessage());
            hasError = true;
        }
        assertTrue(hasError);
    }

}
