package enums;

abstract class MyEnum<T extends MyEnum<T>> implements Comparable<T> {
    static int id = 0;
    private final int ordinal;
    private String name = "";

    MyEnum(String name) {
        this.name = name;
        ordinal = id++;
    }

    public int ordinal() {
        return ordinal;
    }

    public String name() {
        return name;
    }

    public String toString() {
        return name;
    }

    @Override
    public int compareTo(T o) {
        return ordinal - o.ordinal();
    }
}

abstract class MyTransportaion extends MyEnum {
    static final MyTransportaion BUS = new MyTransportaion("BUS", 100) {
        @Override
        int fare(int distance) {
            return distance * BASIC_FARE;
        }
    };
    static final MyTransportaion TRAIN = new MyTransportaion("TRAIN", 150) {
        @Override
        int fare(int distance) {
            return distance * BASIC_FARE;
        }
    };
    protected final int BASIC_FARE;

    private MyTransportaion(String name, int basicFare) {
        super(name);
        this.BASIC_FARE = basicFare;
    }

    abstract int fare(int distance);
}

public class EnumsEx2 {
    public static void main(String[] args) {
        System.out.println(MyTransportaion.BUS.name() + ": " + MyTransportaion.BUS.ordinal());
        System.out.println(MyTransportaion.TRAIN.name() + ": " + MyTransportaion.TRAIN.ordinal());

        MyTransportaion t1 = MyTransportaion.BUS;
        System.out.println(t1 == MyTransportaion.BUS);
    }
}
