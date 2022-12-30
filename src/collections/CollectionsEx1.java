package collections;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class CollectionsEx1 {
    public static void main(String[] args) {
        List list = new ArrayList<Integer>(List.of(1, 2, 3, 4, 5));
        ListIterator<Integer> it = list.listIterator();
        while (it.hasNext()) {
            int item = it.next();
            if (item == 3)
                it.add(11);
            System.out.println(item);
        }
        it.remove();

        while (it.hasPrevious()) {
            System.out.println(it.previous());
        }
    }
}
