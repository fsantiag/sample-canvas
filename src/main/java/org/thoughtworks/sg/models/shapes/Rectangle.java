package org.thoughtworks.sg.models.shapes;

import org.thoughtworks.sg.models.canvas.Point;

public class Rectangle implements Shape {

    private Point[] points;

    public Rectangle(Point... points) {
        this.points = points;
    }

    @Override
    public void draw(Point[][] matrix) {
        Point upperLeftCorner = this.points[0];
        Point lowerRightCorner = this.points[1];
        Point upperRightCorner = new Point(upperLeftCorner.getI(), lowerRightCorner.getJ());
        Point lowerLeftCorner = new Point(lowerRightCorner.getI(), upperLeftCorner.getJ());

        Line top = new Line(upperLeftCorner, upperRightCorner);
        Line bottom = new Line(lowerLeftCorner, lowerRightCorner);
        Line left = new Line(upperLeftCorner, lowerLeftCorner);
        Line right = new Line(upperRightCorner, lowerRightCorner);

        top.draw(matrix);
        bottom.draw(matrix);
        left.draw(matrix);
        right.draw(matrix);
    }
}
