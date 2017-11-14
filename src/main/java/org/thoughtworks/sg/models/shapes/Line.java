package org.thoughtworks.sg.models.shapes;

import org.thoughtworks.sg.models.canvas.Point;

public class Line implements Shape {

    public static final String DEFAULT_LINE_COLOR = "x";
    private Point[] points;

    public Line(Point... points) {
        this.points = points;
    }

    @Override
    public void draw(Point[][] canvas) {
        this.draw(canvas, DEFAULT_LINE_COLOR);
    }

    public void draw(Point[][] canvas, String color) {
        Point start = points[0];
        Point end = points[1];

        for(int i = start.getI(); i <= end.getI(); i++) {
            for(int j = start.getJ(); j <= end.getJ(); j++) {
                canvas[i][j] = new Point(i, i, color);
            }
        }
    }
}
