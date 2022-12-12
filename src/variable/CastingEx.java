package variable;

public class CastingEx {
    public static void main(String[] args) {
        float f = 9.1234567f;
        double d1 = 9.1234567;
        double d2 = (double) f;

        System.out.printf("f = %20.18f %n", f);
        System.out.printf("d1 = %20.18f %n", d1);
        System.out.printf("d2 = %20.18f %n", d2);
    }
}
