package org.thoughtworks.sg.models.shapes;

import org.thoughtworks.sg.models.canvas.Point;

public interface Shape {
    void draw(Point[][] matrix);
}
