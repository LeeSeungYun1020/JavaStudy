package tpc.poly;

public abstract class Animal { // 추상 클래스 -> 객체 생성 불가
     public abstract void eat(); // 추상 메소드

     public void move() { // 구현 메소드
          System.out.println("move!");
     }
}
