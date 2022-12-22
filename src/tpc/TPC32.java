package tpc;

public class TPC32 {
    public static void main(String[] args) {
        String cmp1 = new String("APP");
        String cmp2 = new String("APP");
        System.out.println(cmp1 == cmp2);
        System.out.println(cmp1.equals(cmp2));

        String cmp3 = "APP";
        String cmp4 = "APP";
        System.out.println(cmp3 == cmp4);
        System.out.println(cmp3.equals(cmp4));

        System.out.println(cmp1 == cmp3);
        System.out.println(cmp1.equals(cmp3));
    }
}
