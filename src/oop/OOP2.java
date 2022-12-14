package oop;

public class OOP2 {
    static {
        System.out.println("클래스 초기화 블록");
    }

    {
        System.out.println("인스턴스 초기화 블록");
    }

    public OOP2() {
        System.out.println("생성자");
    }

    public static void main(String[] args) {
        System.out.println("시작");
        System.out.println("o1 생성");
        OOP2 o1 = new OOP2();
        System.out.println("o2 생성");
        OOP2 o2 = new OOP2();
        System.out.println("종료");
    }
}
