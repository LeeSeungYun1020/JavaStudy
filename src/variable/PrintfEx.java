package variable;

public class PrintfEx {
    public static void main(String[] args) {
        float f1 = .10f;
        float f2 = 1e1f;
        float f3 = 3.14e3f;
        double d = 1.23456789;
        String str = "abcdefghijk";

        System.out.printf("f1=%f, %e, %g %n", f1, f1, f1);
        System.out.printf("f1=%f, %e, %g %n", f1, f1, f1);
        System.out.printf("f1=%f, %e, %g %n", f1, f1, f1);

        System.out.printf("d = %f %n", d);
        System.out.printf("d = %14.10f%n", d);

        System.out.printf("[%s]%n", str);
        System.out.printf("[%20s]%n", str);
        System.out.printf("[%-20s]%n", str);
        System.out.printf("[%.8s]%n", str);
    }
}
