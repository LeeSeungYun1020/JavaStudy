package oop;

public class OOP3 {
    public static void main(String[] args) {
        Point3D p1 = new Point3D(1, 3, 5);
        System.out.println(p1.getLocation());
    }
}

class Point {
    int x, y;

    Point() {
        this(0, 0);
    }

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    String getLocation() {
        return "x: " + x + ", y: " + y;
    }
}

class Point3D extends Point {
    int z;

    Point3D() {
        this(0, 0, 0);
    }

    Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    @Override
    String getLocation() {
        return super.getLocation() + ", z: " + z;
    }
}