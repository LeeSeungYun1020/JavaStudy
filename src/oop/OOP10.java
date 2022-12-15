package oop;

public class OOP10 {
    int a = 3;

    void addA() {
        a += 3;
    }
    void method() {
        final int level = 0;
        class LocalClass {
            int in1 = level;
            int in2 = a;
            void print() {
                System.out.println(in1 + ", " + in2);
            }
        }
        LocalClass lc1 = new LocalClass();
        lc1.print();
        // level += 3;
        LocalClass lc2 = new LocalClass();
        lc2.print();
    }

    static void staticMethod() {
        class LocalClass {
            // int in1 = a;
        }
    }

    public static void main(String[] args) {
        OOP10 o1 = new OOP10();
        o1.addA();
        o1.method();
        o1.addA();
        o1.method();
    }
}
