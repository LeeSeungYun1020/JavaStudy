package conditional;

public class Conditional1 {
    public static void main(String[] args) {
        final String INIT = "Init";
        int num = 1;
        String result = INIT;
        if (num == 1) {
            result = "one";
        } else {
            result = "else";
        }

        switch (result) {
            case INIT:
                System.out.println("init");
                break;
            case "one":
                System.out.println("one");
                break;
            default:
                System.out.println("something");
        }
    }
}
