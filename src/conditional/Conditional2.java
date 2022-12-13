package conditional;

import java.util.Scanner;

public class Conditional2 {
    public static void main(String[] args) {
        System.out.println("가위(1), 바위(2), 보(3)\n>>");
        Scanner scanner = new Scanner(System.in);
        int user = scanner.nextInt();
        int com = (int) (Math.random() * 3) + 1;

        System.out.println("You: " + user);
        System.out.println("Com: " + com);
        switch (user - com) {
            case 2: case -1:
                System.out.println("LOSE!");
                break;
            case 1: case -2:
                System.out.println("Win!!");
                break;
            case 0:
                System.out.println("Draw!");
        }
    }
}
