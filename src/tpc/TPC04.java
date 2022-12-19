package tpc;

public class TPC04 {
    public static void main(String[] args) {
        // 데이터 이동 - 변수와 배열의 관계
        int a = 1, b = 2, c = 3;
        sum(1, 2, 3);

        int[] arr = new int[3];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        sum(arr);
    }

    public static void sum(int x, int y, int z) {
        int s = x + y + z;
        System.out.println(s);
    }

    public static void sum(int[] arr) {
        int s = 0;
        for (int i : arr) {
            s += i;
        }
        System.out.println(s);
    }
}
