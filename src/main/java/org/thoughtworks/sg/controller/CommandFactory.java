package org.thoughtworks.sg.controller;

import org.thoughtworks.sg.controller.commands.*;
import org.thoughtworks.sg.exceptions.CommandValidationException;

import static org.thoughtworks.sg.controller.CommandType.*;

public class CommandFactory {
    public static AbstractCommand getCommand(String type){
        if (QUIT.getValue().equalsIgnoreCase(type)) return new QuitCommand();
        if (LINE.getValue().equalsIgnoreCase(type)) return new DrawLineCommand();
        if (RECTANGLE.getValue().equalsIgnoreCase(type)) return new DrawRectangleCommand();
        if (BUCKET.getValue().equalsIgnoreCase(type)) return new DrawBucketFillCommand();
        if (CREATE.getValue().equalsIgnoreCase(type)) return new CreateCanvasCommand();
        throw new CommandValidationException("Invalid commands.");
    }
}
