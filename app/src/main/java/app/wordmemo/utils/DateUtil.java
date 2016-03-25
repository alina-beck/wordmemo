package app.wordmemo.utils;

import java.util.Calendar;

public abstract class DateUtil {

    public static String formatDate(Calendar calendar) {
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        StringBuilder sb = new StringBuilder();
        sb.append(year).append("-").append(month).append("-").append(day);

        return sb.toString();
    }

    public static Calendar formatDate(String dateString) {
        String[] s = dateString.split("-");
        Calendar calendar = Calendar.getInstance();
        calendar.set(Integer.parseInt(s[0]), Integer.parseInt(s[1]), Integer.parseInt(s[2]));

        return calendar;

    }
}
