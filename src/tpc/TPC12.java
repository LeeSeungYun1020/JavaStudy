package tpc;

import tpc.bit.BookVO;

public class TPC12 {
    public static void main(String[] args) {
        BookVO b1 = new BookVO();
        System.out.println(b1.title + "\t" + b1.price + "\t" + b1.company + "\t" + b1.page);

        BookVO b2 = new BookVO("Python", 18_000, "publisher", 140);
        System.out.println(b2.title + "\t" + b2.price + "\t" + b2.company + "\t" + b2.page);
    }
}
