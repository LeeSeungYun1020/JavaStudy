package tpc.poly;

public class Radio implements RemoCon{
    @Override
    public void chUp() {
        System.out.println("radio channel up");
    }

    @Override
    public void chDown() {
        System.out.println("radio channel down");
    }

    @Override
    public void internet() {
        System.out.println("internet unavailable");
    }
}
