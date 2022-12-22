package tpc;

import tpc.poly.Ago;
import tpc.poly.Bgo;

public class TPC29 {
    public static void main(String[] args) {
        Ago a = new Ago();
        Bgo b = new Bgo();
        display(a);
        display(b);
    }

    public static void display(Object o) {
        if (o instanceof Ago)
            ((Ago) o).go();
        else if (o instanceof  Bgo)
            ((Bgo) o).go();
    }
}
