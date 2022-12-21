package tpc.poly;

public class TV implements RemoCon{
    public int currentCh = 10;
    @Override
    public void chUp() {
        if (currentCh < MAX_CH) {
            currentCh++;
        } else {
            currentCh = 1;
        }
        System.out.println("tv channel up " + currentCh);
    }

    @Override
    public void chDown() {
        if (currentCh > 1) {
            currentCh--;
        } else {
            currentCh = MAX_CH;
        }
        System.out.println("tv channel down " + currentCh);
    }

    @Override
    public void internet() {
        System.out.println("internet available");
    }
}
