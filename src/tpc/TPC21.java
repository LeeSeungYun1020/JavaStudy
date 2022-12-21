package tpc;

import tpc.bit.Animal;
import tpc.bit.Cat;
import tpc.bit.Dog;

public class TPC21 {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.eat();

        Cat c = new Cat();
        c.eat();
        c.night();

        Animal ani = new Dog();
        ani.eat();
        ani = new Cat(); // up casting
        ani.eat();
        ((Cat)ani).night(); // down casting
    }
}
