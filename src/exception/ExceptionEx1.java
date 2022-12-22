package exception;

public class ExceptionEx1 {
    public static void main(String[] args) {
        int num = 100;
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println(num / (int)(Math.random() * 10));
            } catch (ArithmeticException e) {
                System.out.println(0);
            }
        }
    }
}
