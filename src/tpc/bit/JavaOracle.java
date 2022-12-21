package tpc.bit;

public class JavaOracle implements DBConnect{
    @Override
    public void getConnection(String url, String user, String password) {
        System.out.println("OracleDB 접속");
    }
}
