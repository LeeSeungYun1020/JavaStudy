package tpc;

public class TPC06 {
    public static void main(String[] args) {
        // 메소드와 변수
        // 메소드 - 동작, 기능
        int a = 3;
        int b = 4;
        int c = sum(a, b);
        System.out.println(c);

        int[] arr = makeArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static int sum(int a, int b) {

        return a + b;
    }

    public static int[] makeArray() {
        return new int[] {1, 2, 3};
    }
}
