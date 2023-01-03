package enums;

enum Transportation {
    BUS(100) {
        @Override
        int fare(int distance) {
            return distance * basicFare;
        }
    }, TRAIN(150) {
        @Override
        int fare(int distance) {
            return distance * basicFare;
        }
    }, AIRPLANE(300) {
        @Override
        int fare(int distance) {
            return distance * basicFare;
        }
    };

    protected final int basicFare;

    Transportation(int basicFare) {
        this.basicFare = basicFare;
    }

    abstract int fare(int distance);

    public int getBasicFare() {
        return basicFare;
    }
}

public class EnumsEx1 {
    public static void main(String[] args) {
        System.out.println("Bus: " + Transportation.BUS.fare(100));
        System.out.println("Train: " + Transportation.TRAIN.fare(100));
        System.out.println("Airplane: " + Transportation.AIRPLANE.fare(100));
    }
}
