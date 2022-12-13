package array;

import java.util.Arrays;

public class Array1 {
    public static void main(String[] args) {
        int[] arr = new int[]{}; //new int[0] 또는 그냥 {}
        System.out.println(arr);
        System.out.println(arr.length);
        System.out.println(arr == null);

        int[] arr2 = {1, 2, 3};
        System.out.println(Arrays.toString(arr2));

        char[] arr3 = {'e', 'n', 'g'};
        System.out.println(arr3);
    }
}
