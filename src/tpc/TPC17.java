package tpc;

import tpc.bit.MovieVO;

public class TPC17 {
    public static void main(String[] args) {
        int[] a = new int[]{0, 1, 2};
        for (int v : a) {
            System.out.println(v);
        }

        MovieVO mv = new MovieVO("Avatar", 20_000, "robot", 12, 1.4);
        System.out.println(mv);

        // 객체 배열
        MovieVO[] ma = new MovieVO[3];
        ma[0] = new MovieVO("Movie1", 20_000, "robot", 12, 1.4);
        ma[1] = new MovieVO("Movie2", 15_000, "robot", 15, 1.1);
        ma[2] = new MovieVO("Movie3", 24_000, "robot", 18, 1.5);

        for (MovieVO vo: ma) {
            System.out.println(vo);
        }
    }


}
