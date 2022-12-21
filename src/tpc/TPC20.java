package tpc;

import tpc.bit.Animal;
import tpc.bit.Cat;
import tpc.bit.Dog;

public class TPC20 {
    public static void main(String[] args) {
        Animal dog = new Dog();
        dog.eat();

        Animal cat = new Cat();
        cat.eat();
        ((Cat)cat).night();
    }
}
