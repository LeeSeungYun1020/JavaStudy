package tpc;

public class TPC31 {
    public static void main(String[] args) {
        java.lang.String str1 = "string";
        String str2 = "strrrring";
        System.out.println(str1 == str2);
        System.out.println(str1.equals(str2));

        System.out.println(str1.charAt(1));
        System.out.println(str1.length());
        System.out.println(str1.indexOf("ng"));
        System.out.println(str1.indexOf("ap"));
        System.out.println(str2.replace("r", "a"));
    }
}
