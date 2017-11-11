package org.thoughtworks.sg.command;

import org.thoughtworks.sg.command.entities.*;
import org.thoughtworks.sg.exceptions.CommandValidationException;

import static org.thoughtworks.sg.command.CommandType.*;

public class CommandFactory {
    public static AbstractCommand getCommand(String type){
        if (QUIT.getValue().equalsIgnoreCase(type)) return new CommandQ();
        if (LINE.getValue().equalsIgnoreCase(type)) return new CommandL();
        if (RECTANGLE.getValue().equalsIgnoreCase(type)) return new CommandR();
        if (BUCKET.getValue().equalsIgnoreCase(type)) return new CommandB();
        if (CREATE.getValue().equalsIgnoreCase(type)) return new CommandC();
        if (CROSS.getValue().equalsIgnoreCase(type)) return new CommandX();
        throw new CommandValidationException("Invalid command.");
    }
}
