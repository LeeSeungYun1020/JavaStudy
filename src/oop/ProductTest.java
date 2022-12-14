package oop;

class Product {
    static int count = 0;
    int serialNo;
    String name;

    {
        // 인스턴스 초기화 블록
        ++count;
        serialNo = count;
    }

    Product() {
        this("product" + count);
    }

    Product(String name) {
        this.name = name;
    }
}

public class ProductTest {
    public static void main(String[] args) {
        Product p1 = new Product();
        System.out.println(p1.serialNo);
        Product p2 = new Product();
        System.out.println(p2.name);
        Product p3 = new Product("machine");
        System.out.println(p3.serialNo);
        Product p4 = new Product();
        System.out.println(p4.name);
    }
}
