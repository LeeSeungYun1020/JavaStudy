package operator;

public class Operator4 {
    public static void main(String[] args) {
        int a = 1_000_000;
        int b = 2_000_000;

        long result1 = a * b;
        long result2 = (long)a * b;
        System.out.println(result1);
        System.out.println(result2);

        int result3 = a * a / a;
        int result4 = a / a * a;
        System.out.println(result3);
        System.out.println(result4);
    }
}
