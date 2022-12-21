package tpc;

import com.google.gson.*;
import tpc.bit.BookVO;
import tpc.bit.MyUtil;

//import java.lang.*; // 디폴트 패키지(생략 가능)능
public class TPC18 {
    public static void main(String[] args) {
        // 1. Java에서 제공해주는 클래스
        String str = "something";
        System.out.println(str.toUpperCase());
        // 2. 직접 만들어서 사용하는 클래스
        System.out.println(MyUtil.ten());
        // 3. 다른 사람이 만들어 제공하는 클래스
        Gson g = new Gson();
        BookVO bookVO = new BookVO("title", 10_000, "publisher",  450);
        System.out.println(g.toJson(bookVO));
    }
}
