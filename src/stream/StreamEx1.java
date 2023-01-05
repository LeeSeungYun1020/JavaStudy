package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class StreamEx1 {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>(List.of(new String[]{"kim", "lee", "park"}));
        Stream<Person> students = Stream.generate(() -> {
            int i = new Random().nextInt(100);
            return new Person(names.get(i % 3), i);
        }).limit(5);
        students.forEach(System.out::println);
    }
}

class Person {
    private final String name;
    private final int score;

    public Person(String name, int score) {
        this.name = name;
        this.score = score;
    }


    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}