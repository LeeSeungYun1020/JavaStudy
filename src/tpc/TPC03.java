package tpc;

import tpc.bit.Book;
import tpc.bit.PersonVO;

public class TPC03 {
    public static void main(String[] args) {
        // 관계 이해하기 PDT vs UDDT

        // 정수 하나가 필요
        int a = 10;

        // 책 하나가 필요
        Book b = new Book();
        b.title = "Java programming";
        b.price = 34000;
        b.company = "출판사1";
        b.page = 340;
        System.out.println(b.title + " " + b.price + " " + b.company + " " + b.page);

        PersonVO p = new PersonVO();
        p.name = "윤";
        p.age = 27;
        p.height = 171.3f;
        p.weight = 60.3f;
    }
}
