package formatting;

import java.time.ZonedDateTime;
import java.util.GregorianCalendar;

public class TimeEx3 {
    public static void main(String[] args) {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        GregorianCalendar gregorianCalendar = GregorianCalendar.from(zonedDateTime);
        gregorianCalendar.toZonedDateTime();
    }
}
