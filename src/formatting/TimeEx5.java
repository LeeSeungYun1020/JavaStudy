package formatting;

import java.time.Duration;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class TimeEx5 {
    public static void main(String[] args) {
        LocalTime time1 = LocalTime.of(9, 0, 0);
        LocalTime time2 = LocalTime.now();
        Duration duration = Duration.between(time1, time2);

        System.out.println(duration.getSeconds());
        System.out.println(time1.until(time2, ChronoUnit.SECONDS));
        System.out.println(duration);

        LocalTime localTime = LocalTime.of(0, 0).plusSeconds(duration.getSeconds());
        System.out.println(localTime.getHour() + ":" + localTime.getMinute() + ":" + localTime.getSecond());
    }
}
