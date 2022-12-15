package oop;

public class OOP9 {
    public static void main(String[] args) {
        I i1 = InstanceManager.getInstance();
        i1.play();
    }
}

class E implements I {
    @Override
    public void play() {
        System.out.println("PLAY E");
    }
}

class InstanceManager {
    public static I getInstance() {
        return new E();
    }
}