package tpc.bit;

public class BookVO {
    public String title;
    public int price;
    public String company;
    public int page;

    public BookVO() {
        // 초기화 작업
        this.title = "title";
        this.price = 0;
        this.company = "company";
        this.page = 0;
    }

    // 생성자 메소드의 중복 정의 (오버로딩), 이름이 같아도 개수 타입이 다르면 가능
    public BookVO(String title, int price, String company, int page) {
        this.title = title;
        this.price = price;
        this.company = company;
        this.page = page;
    }
}
