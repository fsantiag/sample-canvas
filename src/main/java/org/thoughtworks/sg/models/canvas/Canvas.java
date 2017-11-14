package org.thoughtworks.sg.models.canvas;

import org.thoughtworks.sg.models.shapes.Shape;

public class Canvas {

    public static final int CANVAS_BORDER_COMPENSATION = 2;
    private Point[][] matrix;

    private int lines;
    private int columns;

    public Canvas(int lines, int columns) {
        this.columns = columns + CANVAS_BORDER_COMPENSATION;
        this.lines = lines + CANVAS_BORDER_COMPENSATION;

        matrix = new Point[this.lines][this.columns];

        createEmptyCanvas();
    }

    public void drawShape(Shape shape) {
        shape.draw(matrix);
    }

    public void drawLine(Point p1, Point p2, String color) {
        for(int i = p1.getI(); i <= p2.getI(); i++) {
            for(int j = p1.getJ(); j <= p2.getJ(); j++) {
                matrix[i][j] = new Point(i, i, color);
            }
        }
    }

    public void render() {
        for(int i = 0; i < this.lines; i++) {
            for(int j = 0; j < this.columns; j++) {
                System.out.print(matrix[i][j].getColor());
            }
            System.out.println();
        }
    }

    public Point[][] getMatrix() {
        return matrix;
    }

    private void createEmptyCanvas() {
        createCanvasBorders();
        setCanvasCorners();
        setCanvasValuesToEmpty();

    }

    private void setCanvasValuesToEmpty() {
        for(int i = 1; i < this.lines - 1; i++) {
            for(int j = 1; j < this.columns - 1; j++) {
                matrix[i][j] = new Point(i, j);
            }
        }
    }

    private void createCanvasBorders() {
        drawLine(new Point(0, 0), new Point(0, this.columns - 1), "-");
        drawLine(new Point(this.lines - 1, 0), new Point(this.lines - 1, this.columns - 1), "-");
        drawLine(new Point(1, 0), new Point( this.lines - 1, 0), "|");
        drawLine(new Point(1, this.columns - 1), new Point(this.lines - 1, this.columns - 1), "|");
    }

    private void setCanvasCorners() {
        matrix[0][0] = new Point(0, 0, "*");
        matrix[0][this.columns - 1] = new Point(0, this.columns - 1, "*");
        matrix[this.lines - 1][0] = new Point(this.lines - 1, 0, "*");
        matrix[this.lines - 1][this.columns - 1] = new Point(this.lines - 1, this.columns - 1, "*");
    }

    public int getLines() {
        return lines;
    }

    public int getColumns() {
        return columns;
    }

}
