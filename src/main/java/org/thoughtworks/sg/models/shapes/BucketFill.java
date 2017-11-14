package org.thoughtworks.sg.models.shapes;

import org.thoughtworks.sg.models.canvas.Point;

public class BucketFill implements Shape {

    private String color;
    private Point point;

    public BucketFill(Point start, String color) {
        this.color = color;
        this.point = start;
    }

    @Override
    public void draw(Point[][] matrix) {
        this.bucketFill(matrix, this.point.getI(), this.point.getJ(), this.color);
    }

    private void bucketFill(Point[][] canvas, int i, int j, String color) {
        int lines = canvas.length;
        int columns = canvas[0].length;

        if (i < 1 || i > lines - 2) return;
        if (j < 1 || j > columns - 2) return;

        Point point = canvas[i][j];
        if (point.getColor().equals("x")) return;
        if (point.getColor().equals(color)) return;

        point.setColor(color);

        bucketFill(canvas, i - 1, j, color);
        bucketFill(canvas, i + 1, j, color);
        bucketFill(canvas, i, j - 1, color);
        bucketFill(canvas, i, j + 1, color);
    }
}
