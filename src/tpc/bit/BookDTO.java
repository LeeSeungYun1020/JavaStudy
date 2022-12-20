package tpc.bit;

public class BookDTO {
    public String title;
    public int price;
    public String company;
    public int page;

    // 생성자가 없는 경우 기본 생성자가 컴파일러에 의해 생성됨
    public BookDTO() {
        // 객체를 생성하는 작업 (기계어 코드 단위)
        super();
    }

    public BookDTO(String title, int price, String company, int page) {
        this.title = title;
        this.price = price;
        this.company = company;
        this.page = page;
    }
}
