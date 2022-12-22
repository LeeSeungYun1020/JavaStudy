package tpc;

import tpc.inf.ObjectArray;
import tpc.poly.Ago;
import tpc.poly.Bgo;

public class TPC34 {
    public static void main(String[] args) {
        ObjectArray array = new ObjectArray(3);
        array.add(new Ago());
        array.add(new Bgo());
        array.add(new Ago());

        for (int i = 0; i < array.size(); i++) {
            Object item = array.get(i);
            if (item instanceof Ago)
                ((Ago) item).go();
            else if (item instanceof Bgo) {
                ((Bgo) item).go();
            }
        }
    }
}
