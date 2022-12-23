package exception;

public class ExceptionEx3 {
    public static void main(String[] args) {
        try {
            print();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void print() throws ExceptionA {
        System.out.println("print");
        throw new ExceptionA();
    }
}
