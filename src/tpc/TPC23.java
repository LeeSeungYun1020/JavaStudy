package tpc;

import tpc.bit.Animal;
import tpc.bit.Cat;
import tpc.bit.Dog;

public class TPC23 {
    public static void main(String[] args) {
        // 다형성 인수
        Dog dog = new Dog();
        Cat cat = new Cat();
        display(dog);
        display(cat);
    }

    public static void display(Animal animal) {
        animal.eat();
        if (animal instanceof Cat)
            ((Cat)animal).night();
    }
}
