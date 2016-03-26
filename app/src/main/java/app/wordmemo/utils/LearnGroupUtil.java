package app.wordmemo.utils;

import java.util.Calendar;

public abstract class LearnGroupUtil {

    private static final int GROUP_1 = 1;
    private static final int GROUP_2 = 2;
    private static final int GROUP_3 = 5;
    private static final int GROUP_4 = 10;
    private static final int GROUP_5 = 20;

    public Calendar calculateDueDate (int group) {
        int increaseDays;

        switch (group) {
            case 1:
                increaseDays = GROUP_1;
                break;
            case 2:
                increaseDays = GROUP_2;
                break;
            case 3:
                increaseDays = GROUP_3;
                break;
            case 4:
                increaseDays = GROUP_4;
                break;
            case 5:
                increaseDays = GROUP_5;
                break;
            default:
                increaseDays = GROUP_1;
                break;
        }

        Calendar newDueDate = Calendar.getInstance();
        newDueDate.add(Calendar.DATE, increaseDays);

        return newDueDate;
    }

}
