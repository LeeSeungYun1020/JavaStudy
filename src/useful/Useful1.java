package useful;

import java.util.Objects;

public class Useful1 {
    public static void main(String[] args) {
        Circle c1 = new Circle(new Point(3, 4), 10);
        Circle c2 = c1.clone();
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c1 == c2);
        System.out.println(c1.equals(c2));
    }
}

class Point implements Cloneable {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point() {
        this(0, 0);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public Point clone() {
        return new Point(this.x, this.y);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Point) {
            Point cmp = (Point) obj;
            return this.x == cmp.x && this.y == cmp.y;
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}

class Circle {
    private Point center;
    private int radius;

    public Circle(Point center, int radius) {
        this.center = center.clone();
        this.radius = radius;
    }

    public Circle() {
        this.center = new Point();
        this.radius = 0;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "center=" + center +
                ", radius=" + radius +
                '}';
    }

    @Override
    public Circle clone() {
        return new Circle(this.center.clone(), this.radius);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Circle) {
            Circle cmp = (Circle) obj;
            return cmp.radius == this.radius && cmp.center.equals(this.center);
        } else {
            return false;
        }
    }
}
