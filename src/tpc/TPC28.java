package tpc;
import tpc.poly.A;
public class TPC28 {
    public static void main(String[] args) {
        A a = new A();
        a.display();
        System.out.println(a);

        Object o = new A();
        if (o instanceof A) {
            ((A) o).display();
        }
        System.out.println(o);
    }
}
