package tpc;

import tpc.bit.Overload;

public class TPC16 {
    public static void main(String[] args) {
        Overload.sum(20, 50);
        Overload.sum(23.4, 56);
        Overload.sum(56.7, 78.9);
    }
}
