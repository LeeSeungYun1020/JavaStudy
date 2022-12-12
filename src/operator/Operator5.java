package operator;

public class Operator5 {
    public static void main(String[] args) {
        double pi = 3.141592;

        double roundPi = (int) (pi * 1000  + 0.5) / 1000d;
        System.out.println(roundPi);
        System.out.println(Math.round(pi * 1000) / 1000d);
    }
}
