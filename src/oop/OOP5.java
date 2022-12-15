package oop;

public class OOP5 {
    public static void main(String[] args) {
        Parent p1 = new Child();
        p1.print();
        System.out.println(p1.x);

        Child c1 = (Child) p1;
        c1.print();
        System.out.println(c1.x);
    }
}

class Parent {
    int x = 100;

    void print() {
        System.out.println("parent");
    }
}

class Child extends Parent {
    int x = 200;

    void print() {
        System.out.println("child");
    }
}
