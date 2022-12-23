package exception;

public class ExceptionEx5 {
    public static void main(String[] args) {
        try {
            System.out.println("start try");
            return;
        } catch (Exception e) {
            System.out.println("start exception");
        } finally {
            System.out.println("start finally");
        }
        System.out.println("return?");
    }
}
