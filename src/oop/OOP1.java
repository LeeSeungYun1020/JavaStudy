package oop;

public class OOP1 {
    public static void main(String[] args) {
        System.out.println(concatenate(",", new String[]{"abc", "def"}));
        System.out.println("[" + concatenate("-", new String[0]) + "]");
        System.out.println(concatenate("+", "aaaa", "bbbb"));
    }

    static String concatenate(String delim, String... args) {
        String result = "";
        for (String str: args) {
            result += str + delim;
        }
        return result;
    }
}
