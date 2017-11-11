package org.thoughtworks.sg.exceptions;

public class CommandValidationException extends RuntimeException{
    public CommandValidationException(String message) {
        super(message);
    }
}
