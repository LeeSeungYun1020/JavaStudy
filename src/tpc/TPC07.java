package tpc;

import java.util.Arrays;

public class TPC07 {
    public static void main(String[] args) {
        int a = 20;
        float b = 56.7f;
        float v = sum(a, b); // call by value
        System.out.println(v);

        int[] arr = {1, 2, 3, 4, 5};
        int v2 = arrSum(arr);
        System.out.println(v2);

        System.out.println(sum(a, v2));
        System.out.println("a: "+ a + ", v2: " + v2);

    }

    public static float sum(int a, float b) {
        return a + b;
    }

    public static int arrSum(int[] x) {
        return Arrays.stream(x).sum();
    }

    public static int sum(int a, int b) {
        int s = a + b;
        a = 0;
        b = 0;
        System.out.println("a: "+ a + ", b: " + b);
        return s;
    }
}
