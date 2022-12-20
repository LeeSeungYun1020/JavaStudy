package tpc;

public class TPC09 {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        TPC09 tpc = new TPC09();
        int v = tpc.add(a, b);
        System.out.println(v);
    }

    public int add(int a, int b) {
        int sum = a + b;
        return sum;
    }
}