package org.thoughtworks.sg.core;

public class Point {
    private int i;
    private int j;
    private String color;


    public Point(int i, int j, String color) {
        this.i = i;
        this.j = j;
        this.color = color;
    }

    public Point(int i, int j) {
        this.i = i;
        this.j = j;
        this.color = " ";
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }
}
