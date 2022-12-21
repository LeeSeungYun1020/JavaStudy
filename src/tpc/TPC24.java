package tpc;

import tpc.bit.Animal;
import tpc.bit.Cat;
import tpc.bit.Dog;

public class TPC24 {
    public static void main(String[] args) {
        // 다형성 배열
        Animal[] arr = new Animal[] {new Dog(), new Cat()};
        display(arr);
    }

    private static void display(Animal[] arr) {
        for(Animal ani: arr) {
            ani.eat();
            if (ani instanceof Cat)
                ((Cat)ani).night();
        }
    }
}
