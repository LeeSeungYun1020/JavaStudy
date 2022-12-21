package tpc;

import tpc.bit.DBConnect;
import tpc.bit.JavaMySQL;
import tpc.bit.JavaOracle;

public class TPC27_1 {
    public static void main(String[] args) {
        DBConnect connect = new JavaMySQL();
        connect.getConnection("url", "user1", "1234");

        connect = new JavaOracle();
        connect.getConnection("url", "user2", "abcd");
    }
}
