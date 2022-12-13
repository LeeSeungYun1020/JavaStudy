package array;

import java.util.Arrays;

public class Array3 {
    public static void main(String[] args) {
        int[] numArr = new int[10];
        for (int i = 0; i < numArr.length; i++) {
            numArr[i] = i;
        }

        System.out.println(Arrays.toString(numArr));

        for (int i = 0; i < numArr.length; i++) {
            int j = (int)(Math.random() * numArr.length);
            int tem = numArr[i];
            numArr[i] = numArr[j];
            numArr[j] = tem;
        }

        System.out.println(Arrays.toString(numArr));
    }
}
