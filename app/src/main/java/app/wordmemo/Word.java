package app.wordmemo;

import java.util.Date;

public class Word {

    private static int count = 0;

    private final int id = count++;
    private String original;
    private String translation;
    private Date dueDate;

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

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
}