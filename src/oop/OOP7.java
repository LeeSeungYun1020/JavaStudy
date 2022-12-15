package oop;

public class OOP7 {
    public static void main(String[] args) {
        C7 c = new C7();
        c.print();
    }
}

class P7 {
    public void print() {
        System.out.println("P7");
    }
}

interface I7 {
    default void print() {
        System.out.println("I7");
    }
}

class C7 extends P7 implements I7 {

}
