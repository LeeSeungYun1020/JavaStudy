package tpc.bit;

public class Overload {
    private Overload() {}
    public static void sum(int a, int b) {
        System.out.println(a + b);
    }
    public static void sum(double a, int b) {
        System.out.println(a + b);
    }
    public static void sum(double a, double b) {
        System.out.println(a + b);
    }
}
