package stream;

import java.util.Arrays;

public class StreamEx2 {
    public static void main(String[] args) {
        String[] lines = {
                "Do you know apple",
                "what is this",
                "stream has already been operated upon or closed"
        };
        Arrays.stream(lines).flatMap(line -> Arrays.stream(line.split(" "))).sorted().forEach(System.out::println);
    }
}
