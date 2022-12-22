package tpc.inf;

public class IntArray {
    private int count = 0;
    private int[] array;

    public IntArray(int size) {
        array = new int[size];
    }

    public void add(int item) {
        array[count++] = item;
    }

    public int remove() {
        return array[--count];
    }

    public int get(int index) {
        return array[index];
    }

    public int size() {
        return count;
    }
}
