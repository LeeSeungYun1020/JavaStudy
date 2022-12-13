package iteration;

import java.util.Scanner;

public class Iteration3 {
    public static void main(String[] args) {
        int menu = 0, num = 0;
        Scanner scanner = new Scanner(System.in);

        outer:
        while (true) {
            System.out.println("Square(1), Square root(2), log(3)");
            System.out.print(" >> ");
            String input = scanner.nextLine();
            menu = Integer.parseInt(input);
            if (menu == 0) {
                break outer;
            } else if (menu < 0 || 3 < menu) {
                System.out.println("Check input!");
                continue outer;
            }

            for(;;) {
                System.out.println("Enter number, exit(-1), stop(0)");
                System.out.print(" >> ");
                input = scanner.nextLine();
                num = Integer.parseInt(input);

                if (num == -1)
                    break outer;
                if (num == 0)
                    break;

                switch (menu) {
                    case 1:
                        System.out.println("Result: " + num * num);
                        break;
                    case 2:
                        System.out.println("Result: " + Math.sqrt(num));
                        break;
                    case 3:
                        System.out.println("Result: " + Math.log(num));
                }
            }
        }
    }
}
