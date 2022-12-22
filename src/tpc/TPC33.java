package tpc;

import tpc.inf.IntArray;

public class TPC33 {
    public static void main(String[] args) {
        IntArray arr = new IntArray(3);
        arr.add(10);
        arr.add(20);
        arr.add(30);
        for (int i = 0; i < arr.size(); i++) {
            System.out.println(arr.get(i));
        }
        System.out.println(arr.remove());
        System.out.println(arr.size());
    }
}
