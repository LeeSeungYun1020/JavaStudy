package collections;

import java.util.Set;
import java.util.TreeSet;

public class CollectionsEx3 {
    public static void main(String[] args) {
        TreeSet<Integer> set = new TreeSet(Set.of(1, 3, 5, 7, 9, 2, 4, 6));
        System.out.println(set.headSet(5));
        System.out.println(set.tailSet(5));
    }
}
