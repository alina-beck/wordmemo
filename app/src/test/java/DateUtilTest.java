import org.junit.Test;

import java.util.Calendar;
import static org.junit.Assert.*;

import app.wordmemo.utils.DateUtil;

public class DateUtilTest {

    @Test
    public void due_date_should_format_to_string () {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2016, 2, 15);
        String dueDateString = DateUtil.formatDate(calendar);
        assertEquals(dueDateString, "2016-2-15");
    }
    @Test
    public void due_date_should_format_to_calendar () {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2015, 4, 10);
        Calendar dueDateCalendar = DateUtil.formatDate("2015-4-10");
        assertEquals(dueDateCalendar.get(Calendar.YEAR), calendar.get(Calendar.YEAR));
        assertEquals(dueDateCalendar.get(Calendar.MONTH), calendar.get(Calendar.MONTH));
        assertEquals(dueDateCalendar.get(Calendar.DAY_OF_MONTH), calendar.get(Calendar.DAY_OF_MONTH));
    }
}
