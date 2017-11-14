package org.thoughtworks.sg.controller;

public enum CommandType {
    QUIT("Q"),
    LINE("L"),
    RECTANGLE("R"),
    BUCKET("B"),
    CREATE("C");

    private String value;

    CommandType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
