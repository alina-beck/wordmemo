package app.wordmemo.utils;

import org.junit.Test;

import java.util.Calendar;
import static org.junit.Assert.*;

public class DateUtilTest {

    @Test
    public void due_date_should_format_to_int () {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2016, 11, 7);
        int dueDateInt = DateUtil.formatDate(calendar);
        assertEquals(dueDateInt, 20161107);
    }
    @Test
    public void due_date_should_format_to_calendar () {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2015, 4, 10);
        Calendar dueDateCalendar = DateUtil.formatDate(20150410);
        assertEquals(dueDateCalendar.get(Calendar.YEAR), calendar.get(Calendar.YEAR));
        assertEquals(dueDateCalendar.get(Calendar.MONTH), calendar.get(Calendar.MONTH));
        assertEquals(dueDateCalendar.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.DAY_OF_MONTH));
    }
}
