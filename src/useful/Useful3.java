package useful;

import java.util.StringJoiner;

public class Useful3 {
    public static void main(String[] args) {
        String[] arr = {"aAa", "bBb", "cCc"};
        System.out.println(String.join("-", arr));
        StringJoiner sj = new StringJoiner("-", "(", ")");
        for (String s : arr) {
            sj.add(s);
        }
        System.out.println(sj);
    }
}
