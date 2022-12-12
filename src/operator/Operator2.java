package operator;

public class Operator2 {
    public static void main(String[] args) {
        int a = 10, b = 4;
        System.out.println(a / b);

        float zero = 0f;
        // 정수형인 경우 0으로 나누기 불가!!
        System.out.println(a / zero);
    }
}
