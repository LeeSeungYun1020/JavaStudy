package generics;

public class GenericsEx2 {
    public static void main(String[] args) {
        Box box = null;
        Box<Object> objBox = null;
        box = (Box) objBox;
        objBox = (Box<Object>) box;

        Box<String> strBox = null;
        // objBox = (Box<Object>) strBox;
        // strBox = (Box<String>) objBox;
        Box<? extends Object> wBox = new Box<String>();

        FruitBox<? extends Fruit> fruitBox = new FruitBox<Fruit>();
        fruitBox = new FruitBox<Orange>();

        // FruitBox<Fruit> orangeBox = new FruitBox<Orange>();
        FruitBox<?> orangeBox = new FruitBox<Orange>();
        FruitBox<Orange> realOrangeBox = (FruitBox<Orange>) orangeBox;
        FruitBox<Fruit> fruitBox1 = null;
        fruitBox1 = (FruitBox<Fruit>) ((FruitBox<?>) realOrangeBox);
    }
}
