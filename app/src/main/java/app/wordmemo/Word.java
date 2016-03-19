package app.wordmemo;

import java.util.Calendar;

public class Word {

    private static int count = 0;

    private final int id;
    private String original;
    private String translation;
    private Calendar dueDate;

    public Word (String o, String t) {
        this.id = ++count;
        this.original = o;
        this.translation = t;

        Calendar tmpDate = Calendar.getInstance();  // today
        tmpDate.add(Calendar.DATE, 1);              // tomorrow

        this.dueDate = tmpDate;
    }

    public int getId() {
        return id;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public Calendar getDueDate() {
        return dueDate;
    }

    public void setDueDate(Calendar dueDate) {
        this.dueDate = dueDate;
    }
}