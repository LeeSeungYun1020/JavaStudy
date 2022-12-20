package tpc;

import tpc.bit.MemberVO;

public class TPC15 {
    public static void main(String[] args) {
        MemberVO m = new MemberVO("lee", 15, "010-1111-1111", "Seoul");
        System.out.println(m);
    }
}
