package tpc;

public class TPC12_2 {
    public static void main(String[] args) {
        Test test = Test.getInstance();
        test.print();
    }
}

class Test {
    public int a = 3;
    private Test() {}

    public void print() {
        System.out.println("print");
    }

    public static Test getInstance() {
        return new Test();
    }
}