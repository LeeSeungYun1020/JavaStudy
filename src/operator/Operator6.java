package operator;

public class Operator6 {
    public static void main(String[] args) {
        System.out.printf("10 == 10.0f \t %b%n", 10 == 10.0f);
        System.out.printf("10.0 == 10.0f \t %b%n", 10.0 == 10.0f);
        // 오차 발생 가능!
        System.out.printf("0.1 == 0.1f \t %b%n", 0.1 == 0.1f);
    }
}
