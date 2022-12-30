package collections;

import java.util.Arrays;
import java.util.Comparator;

public class CompareEx1 {
    public static void main(String[] args) {
        Custom c1 = new Custom("aaa");
        Custom c2 = new Custom("ccc");
        Custom c3 = new Custom("bbb");
        Custom[] arr = new Custom[] {c3, c2, c1, c3, c1};
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr, new Descending());
        System.out.println(Arrays.toString(arr));
    }
}

final class Custom implements Comparable {

    String str;
    int order;
    private static int stk = 0;
    {
        stk++;
    }

    public Custom() {
        this("tem");
    }

    public Custom(String str) {
        this.str = str;
        this.order = stk;
    }
    @Override
    public int compareTo(Object o) {
        return compareTo((Custom) o);
    }

    public int compareTo(Custom c) {
        int thisVal = this.order;
        int cmpVal = c.order;
        if (thisVal > cmpVal)
            return 1;
        else if (thisVal == cmpVal)
            return 0;
        return -1;
    }

    @Override
    public String toString() {
        return str + "(" + order + ")";
    }
}

class Descending implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        if (o1 instanceof Comparable && o2 instanceof Comparable) {
            return ((Comparable) o2).compareTo(o1);
        }
        return -1;
    }
}