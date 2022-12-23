package useful;

public class Useful2 {
    public static void main(String[] args) {
        try {
            Card c = new Card("HEART", 3);
            Card c2 = Card.class.newInstance();
            Card c3 = c.getClass().newInstance();
            Class clazz = Class.forName("useful.Card");
            Card c4 = (Card) clazz.newInstance();

            System.out.println(c);
            System.out.println(c2);
            System.out.println(c3);
            System.out.println(c4);

            System.out.println(clazz.getName());
            System.out.println(clazz.toGenericString());
            System.out.println(clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}

final class Card {
    String kind;
    int num;

    Card() {
        this("SPADE", 1);
    }

    Card(String kind, int num) {
        this.kind = kind;
        this.num = num;
    }

    @Override
    public String toString() {
        return "Card{" +
                "kind='" + kind + '\'' +
                ", num=" + num +
                '}';
    }
}
