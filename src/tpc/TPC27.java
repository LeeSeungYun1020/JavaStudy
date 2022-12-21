package tpc;

import tpc.poly.Radio;
import tpc.poly.RemoCon;
import tpc.poly.TV;

public class TPC27 {
    public static void main(String[] args) {
        RemoCon r = new TV();
        r.chUp();
        r.chDown();
        r.internet();

        for (int i = 0; i < 100; i++) {
            r.chUp();
        }
        for (int i = 0; i < 100; i++) {
            r.chDown();
        }
    }
}
