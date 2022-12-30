package collections;

public class MyStackTest {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        System.out.println(stack.search(3));
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
