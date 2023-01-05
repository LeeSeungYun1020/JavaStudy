package lambda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LambdaEx1 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        list.forEach(i -> System.out.print(i + ", "));
        System.out.println();

        list.removeIf(x -> x % 2 == 0 || x % 3 == 0);
        System.out.println(list);

        list.replaceAll(x -> x * 10);
        System.out.println(list);

        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < 4; i++) {
            map.put(i + "", i + "");
        }
        map.forEach((key, value) -> System.out.print("{" + key + ", " + value + "}, "));
        System.out.println();

        map.compute("2", (key, value) -> "4");
        System.out.println(map);

    }
}
