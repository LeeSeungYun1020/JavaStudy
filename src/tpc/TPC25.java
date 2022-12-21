package tpc;

import tpc.poly.Animal;
import tpc.poly.Cat;
import tpc.poly.Dog;

public class TPC25 {
    public static void main(String[] args) {
        Animal animal = new Cat();
        animal.eat();

        animal = new Dog();
        animal.eat();
        animal.move();
    }
}