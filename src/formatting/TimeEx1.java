package formatting;

import java.time.LocalDate;
import java.time.chrono.JapaneseDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class TimeEx1 {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        JapaneseDate jDate = JapaneseDate.now();

        System.out.println(date);
        System.out.println(jDate);

        System.out.println(Objects.equals(date, jDate));
        System.out.println(date.equals(jDate));
        System.out.println(date.isEqual(jDate));

        // compareTo 이전 -1, 동일 0, 이후 1
        LocalDate date1 = LocalDate.now().minusDays(1);
        jDate.minus(1, ChronoUnit.DAYS);
        System.out.println(date.compareTo(jDate)); // 다른 타입 비교는 compareTo로 하지 않는 것이 좋음
        System.out.println(date.compareTo(date1));
    }
}
