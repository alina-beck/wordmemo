package app.wordmemo.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Calendar;

import app.wordmemo.utils.DateUtil;

public class Word implements Parcelable {

    private static int count = 0;

    private final int id;
    private String original;
    private String translation;
    private Calendar dueDate;

    /**
        Standard way of creating new words. Automatic dueDate calculation.
    */
    public Word (String o, String t) {
        this.id = ++count;
        this.original = o;
        this.translation = t;

        Calendar tmpDate = Calendar.getInstance();  // today
        tmpDate.add(Calendar.DATE, 1);              // tomorrow

        this.dueDate = tmpDate;
    }

    /**
        Alternative word creation. dueDate is given by parameter.
    */
    public Word (String o, String t, Calendar d) {
        this.id = ++count;
        this.original = o;
        this.translation = t;
        this.dueDate = d;
    }

    /**
        Parcel constructor
     */
    private Word (Parcel in) {
        this.id = in.readInt();
        this.original = in.readString();
        this.translation = in.readString();
        this.dueDate = DateUtil.formatDate(in.readInt());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(original);
        dest.writeString(translation);
        dest.writeInt(DateUtil.formatDate(dueDate));
    }

    public static final Parcelable.Creator<Word> CREATOR = new Parcelable.Creator<Word>() {
        public Word createFromParcel (Parcel in) {
            return new Word(in);
        }
        public Word[] newArray(int size) {
            return new Word[size];
        }
    };

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