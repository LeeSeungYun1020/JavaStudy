package operator;

public class Operator3 {
    public static void main(String[] args) {
        byte a = 10, b = 20;
        // a + b 연산 결과는 int가 된다.
        byte c = (byte) (a + b);
        System.out.println(c);
    }
}
