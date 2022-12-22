package exception;

public class ExceptionEx2 {
    public static void main(String[] args) {
        try {
            if (true)
                throw new ExceptionA();
            else
                throw new ExceptionB();
        } catch (ExceptionA | ExceptionB e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        System.out.println("정상 실행 완료");
    }
}

class ExceptionA extends Exception {

}

class ExceptionB extends Exception {

}
