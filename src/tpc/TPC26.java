package tpc;

import tpc.poly.Radio;
import tpc.poly.RemoCon;
import tpc.poly.TV;

public class TPC26 {
    public static void main(String[] args) {
        RemoCon r = new TV();
        r.chUp();
        r.chDown();
        r.internet();

        r = new Radio();
        r.chUp();
        r.chDown();
        r.internet();
    }
}
