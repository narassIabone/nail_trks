package org.lab0;

public class Segment implements Movable, Comparable<Segment> {
    public Point p1, p2;

    public Segment(Point p1, Point p2) {
        if (p1.getX() == p2.getX() && p1.getY() == p2.getY()) {
            throw new IllegalArgumentException("Точки отрезка не могут совпадать");
        }
        this.p1 = p1;
        this.p2 = p2;
    }

    public double getLength() {
        return Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
    }

    @Override
    public String toString() {
        return "(" + p1 + ", " + p2 + ")";
    }

    @Override
    public void move(double x, double y) {
        p1.move(x, y);
        p2.move(x, y);
    }

    @Override
    public void scale(double m) {
        p1.scale(m);
        p2.scale(m);
    }

    @Override
    public int compareTo(Segment o) {
        return Double.compare(this.getLength(), o.getLength());
    }
}
