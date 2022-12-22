package tpc;

public class TPC36 {
    public static void main(String[] args) {
        int a = 1;
        Integer b = 3;

        Object[] arr = new Object[3];
        arr[0] = 1; // 박싱
        arr[1] = 2;
        arr[2] = 3.14;
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(arr[2]);

        // "100" + "100" = 200
        String x = "100";
        int v = Integer.parseInt(x);
        System.out.println(v + v);

        // 100 + 100 = "100100"
        String s = String.valueOf(x);
        System.out.println(s + s);
    }
}
