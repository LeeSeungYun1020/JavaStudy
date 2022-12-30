package collections;

import java.util.EmptyStackException;
import java.util.Vector;

public class MyStack extends Vector {
    public Object push(Object item) {
        addElement(item);
        return item;
    }

    public Object pop() {
        Object item = peek();
        removeElementAt(size() - 1);
        return item;
    }

    public Object peek() {
        int len = size();
        if (len == 0)
            throw new EmptyStackException();
        return elementAt(len - 1);
    }

    public boolean empty() {
        return size() == 0;
    }

    public int search(Object item) {
        int i = lastIndexOf(item);
        if (i >= 0)
            return size() - i;
        return -1;
    }
}
