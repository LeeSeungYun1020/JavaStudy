package tpc;

import tpc.bit.MemberVO;

public class TPC14 {
    public static void main(String[] args) {
        MemberVO member = new MemberVO();
        member.setName("lee");
        member.setAge(25);
        member.setTel("010-1234-5678");
        member.setAddress("Seoul");

        System.out.println(member.getName() + "\t" + member.getAge() + "\t" +  member.getTel() + "\t" + member.getAddress());
    }
}
