package org.lab0;

public class Triangle implements Movable, Comparable<Triangle> {
    public Point p1, p2, p3;

    public Triangle(Point p1, Point p2, Point p3) {
        if ((p2.getX() - p1.getX()) * (p3.getY() - p1.getY()) == (p3.getX() - p1.getX()) * (p2.getY() - p1.getY())) {
            throw new IllegalArgumentException("Вершины треугольника лежат на одной прямой");
        }
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    public double getArea() {
        return Math.abs(
                p1.getX() * (p2.getY() - p3.getY()) +
                        p2.getX() * (p3.getY() - p1.getY()) +
                        p3.getX() * (p1.getY() - p2.getY())
        ) / 2.0;
    }

    @Override
    public String toString() {
        return "(" + p1 + ", " + p2 + ", " + p3 + ")";
    }

    @Override
    public void move(double x, double y) {
        p1.move(x, y);
        p2.move(x, y);
        p3.move(x, y);
    }

    @Override
    public void scale(double m) {
        p1.scale(m);
        p2.scale(m);
        p3.scale(m);
    }

    @Override
    public int compareTo(Triangle o) {
        return Double.compare(this.getArea(), o.getArea());
    }
}
