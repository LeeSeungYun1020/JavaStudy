package exception;

public class ExceptionEx7 {
    public static void main(String[] args) {
        System.out.println(getValue());
    }

    public static int getValue() {
        try {
            throw new Exception();
        } catch (Exception e) {
            return 1;
        } finally {
            System.out.println("finally");
            return 2;
        }
    }
}
