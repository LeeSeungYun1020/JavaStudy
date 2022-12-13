package array;
import java.util.Arrays;
public class Array2 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
        int[] bigArr = new int[5];
        System.out.println(Arrays.toString(bigArr));
        System.arraycopy(arr, 0, bigArr, 2, 3);
        // src, srcPos, dest, destPos, length
        System.out.println(Arrays.toString(bigArr));
    }
}
