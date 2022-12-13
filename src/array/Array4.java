package array;

import java.util.Scanner;

public class Array4 {
    public static void main(String[] args) {
        String[][] words = {
                {"apple", "사과"},
                {"banana", "바나나"},
                {"car", "차"},
        };

        Scanner scanner = new Scanner(System.in);

        for (String[] word: words) {
            System.out.println(word[0]);
            System.out.print(" >> ");
            String input = scanner.nextLine();
            if (word[1].equals(input)) {
                System.out.println("정답");
            } else {
                System.out.println("오답, 정답은 " + word[1]);
            }
        }
    }
}
