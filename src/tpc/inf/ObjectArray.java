package tpc.inf;

public class ObjectArray {
    private int count = 0;
    private Object[] array;

    public ObjectArray(int size) {
        array = new Object[size];
    }

    public void add(Object item) {
        array[count++] = item;
    }

    public Object remove() {
        return array[--count];
    }

    public Object get(int index) {
        return array[index];
    }

    public int size() {
        return count;
    }
}
