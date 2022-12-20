package tpc;

import tpc.bit.BookDTO;

public class TPC10 {
    public static void main(String[] args) {
        // 기본자료형 int, double, char, boolean
        int a = 10;
        // 사용자정의자료형 Book
        BookDTO book = new BookDTO();
        book.title = "Java";
        book.price = 10_000;
        book.company = "product com";
        book.page = 340;
        System.out.println(book.title);
    }
}
