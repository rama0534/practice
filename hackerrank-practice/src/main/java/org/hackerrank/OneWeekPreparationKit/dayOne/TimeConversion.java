
package org.hackerrank.OneWeekPreparationKit.dayOne;

public class TimeConversion {
    /**
     * This method convert the given time to convert it to military (24-hour) time.
     * given a string
     *
     * @param s time in 12-hour format.
     */
    public static String timeConversion(String s) {
        String period = s.substring(8);
        int hour = Integer.parseInt(s.substring(0, 2));
        String rest = s.substring(2, 8);
        if (period.equals("AM")) {
            if (hour == 12) hour = 0;
        } else { // PM
            if (hour != 12) hour += 12;
        }
        return String.format("%02d%s", hour, rest);
    }

    public static void main(String[]  args) {
        String s = "07:05:45PM";
        System.out.println(timeConversion(s));
    }
}
