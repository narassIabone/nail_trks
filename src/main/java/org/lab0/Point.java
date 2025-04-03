package org.lab0;

public class Point implements Movable, Comparable<Point> {
    private double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    public void parallelMove(double a, double b) {
        x += a;
        y += b;
    }

    public double getDistance() {
        return Math.sqrt(x * x + y * y);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    @Override
    public void move(double x, double y) {
        this.x += x;
        this.y += y;
    }

    @Override
    public void scale(double m) {
        if (m <= 0) {
            throw new IllegalArgumentException("Коэффициент масштабирования должен быть больше нуля");
        }
        this.x *= m;
        this.y *= m;
    }

    @Override
    public int compareTo(Point o) {
        return Double.compare(this.getDistance(), o.getDistance());
    }
}
