package oop;

public class OOP6 {
}

interface Moveable {
    int range = 1;

    // default와 static은 본문 가질 수 있음
    static void printRange() {
        System.out.println(range);
    }

    default void printSomething() {
        System.out.println("something");
    }

    void print();
}

class Car implements Moveable{
    public void print() {
        System.out.println("Car");
    }
}