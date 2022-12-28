package formatting;

import java.util.Calendar;
import java.util.Scanner;

public class CalendarEx1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Year >> ");
        int year = scanner.nextInt();
        System.out.print("Month >> ");
        int month = scanner.nextInt() - 1;

        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        start.set(year, month, 1);
        end.set(year, month, start.getActualMaximum(Calendar.DATE));
        start.add(Calendar.DATE, -start.get(Calendar.DAY_OF_WEEK) + 1);
        end.add(Calendar.DATE, 7 - end.get(Calendar.DAY_OF_WEEK));

        System.out.println(year + "년 " + (month + 1) + "월");
        System.out.println(" SU MO TU WE TH FR SA");
        for (int n = 1; start.before(end) || start.equals(end); start.add(Calendar.DATE, 1)) {
            int day = start.get(Calendar.DATE);
            System.out.print((day < 10) ? "  " + day : " " + day);
            if (n % 7 == 0)
                System.out.println();
            n++;
        }
    }
}
