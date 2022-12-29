package formatting;

import java.time.Instant;
import java.util.Date;

public class TimeEx2 {
    public static void main(String[] args) {
        Instant instant = Instant.now();
        System.out.println(instant.getEpochSecond());
        System.out.println(instant.getNano());

        Date date = Date.from(instant);
        System.out.println(date);
    }
}
