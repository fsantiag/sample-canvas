package org.thoughtworks.sg.command;

public enum CommandType {
    QUIT("Q"),
    LINE("L"),
    RECTANGLE("R"),
    BUCKET("B"),
    CREATE("C"),
    CROSS("X");

    private String value;

    CommandType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
