package app.wordmemo.utils;

import java.util.Calendar;

public abstract class DateUtil {

    public static int formatDate(Calendar calendar) {
        String year = Integer.toString(calendar.get(Calendar.YEAR));
        int monthInt = calendar.get(Calendar.MONTH);
        int dayInt = calendar.get(Calendar.DAY_OF_MONTH);

        String month;
        String day;

        if (monthInt < 10) {
            month = "0" + monthInt;
        }
        else {
            month = Integer.toString(monthInt);
        }

        if (dayInt < 10) {
            day = "0" + dayInt;
        }
        else {
            day = Integer.toString(dayInt);
        }

        return Integer.parseInt(year + month + day);
    }

    public static Calendar formatDate(int dateInt) {
        String dateString = Integer.toString(dateInt);

        Calendar calendar = Calendar.getInstance();
        calendar.set(Integer.parseInt(dateString.substring(0,4)),
                Integer.parseInt(dateString.substring(4,6)),
                Integer.parseInt(dateString.substring(6)));

        return calendar;

    }
}
