package tpc;

import tpc.poly.Ago;
import tpc.poly.Bgo;

public class TPC30 {
    public static void main(String[] args) {
        Object[] oArr = new Object[]{new Ago(), new Bgo()};
        for (Object o: oArr) {
            if (o instanceof Ago)
                ((Ago) o).go();
            else if (o instanceof  Bgo) {
                ((Bgo) o).go();
            }
        }
    }
}
