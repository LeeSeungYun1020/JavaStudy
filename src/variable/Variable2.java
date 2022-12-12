package variable;

public class Variable2 {
    public static void main(String[] args) {
        int a = 1;
        int b = 3;

        System.out.println("a = " + a);
        System.out.println("b = " + b);

        int tem = a;
        a = b;
        b = tem;

        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }
}
