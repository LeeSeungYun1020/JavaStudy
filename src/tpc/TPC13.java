package tpc;

import tpc.bit.BookDTO;

public class TPC13 {
    public static void main(String[] args) {
        // 클래스 - 겍체 - 인스턴스
        String title = "Java";
        int price = 25000;
        String company = "some";
        int page = 720;

        BookDTO dto; // dto 객체
        dto = new BookDTO(title, price, company, page); // dto 인스턴스
        bookPrint(dto);
    }

    public static void bookPrint(BookDTO dto) {
        System.out.println(dto.title + "\t" + dto.price + "\t" + dto.company + "\t" + dto.page);
    }
}
