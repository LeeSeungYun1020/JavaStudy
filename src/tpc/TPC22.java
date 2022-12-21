package tpc;

import tpc.bit.Animal;
import tpc.bit.Cat;
import tpc.bit.Dog;

public class TPC22 {
    public static void main(String[] args) {
        // upcasting
        Animal ani = new Cat();
        Object obj = new Cat();
        ani.eat(); // 컴파일 시점에는 Animal -> 실행 시점에 Cat
        // downcasting
        ((Cat) ani).night();
        ((Cat) obj).eat();

        // 다형성: 같은 이름의 메소드가 서로 다르게 동작하는 원리
        ani = new Dog();
        ani.eat();
    }
}
