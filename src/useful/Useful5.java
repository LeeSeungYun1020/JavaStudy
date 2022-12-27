package useful;

import java.util.Comparator;
import java.util.Objects;

public class Useful5 {
    public static void main(String[] args) {
        String[][] str2D = new String[][]{{"aaa", "bbb"}, {"AAA", "BBB"}};
        String[][] str2D_2 = new String[][]{{"aaa", "bbb"}, {"AAA", "BBB"}};
        System.out.println("equals " + Objects.equals(str2D, str2D_2));
        System.out.println("deep equals " + Objects.deepEquals(str2D, str2D_2));

        System.out.println("isNull " + Objects.isNull(null));
        System.out.println("nonNull " + Objects.nonNull(null));
        System.out.println("hashCode " + Objects.hashCode(null));
        System.out.println("toString " + Objects.toString(null));
        System.out.println("toString(default) " + Objects.toString(null, "default"));

        Comparator<String> c = String.CASE_INSENSITIVE_ORDER;
        System.out.println("compare(aa, bb) " + Objects.compare("aa", "bb", c));
        System.out.println("compare(bb, aa) " + Objects.compare("bb", "aa", c));
        System.out.println("compare(ab, AB) " + Objects.compare("ab", "AB", c));
    }
}

class UsefulA {
    public int a = 5;
}
