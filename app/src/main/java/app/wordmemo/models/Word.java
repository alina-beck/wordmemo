package app.wordmemo.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Calendar;

import app.wordmemo.utils.DateUtil;
import app.wordmemo.utils.LearnGroupUtil;

public class Word implements Parcelable {

    private static final int MAX_LEARN_GROUP = 5;

    private final int id;
    private String original;
    private String translation;
    private int learnGroup;
    private Calendar dueDate;

    public Word (String original, String translation) {
        this(-1, original, translation, 1, null);

        Calendar tmpDate = Calendar.getInstance();  // today
        tmpDate.add(Calendar.DATE, 1);              // tomorrow
        this.dueDate = tmpDate;
    }

    public Word (int id, String original, String translation, int learnGroup, Calendar cal) {
        this.id = id;
        this.original = original;
        this.translation = translation;
        this.learnGroup = learnGroup;
        this.dueDate = cal;
    }

    public void updateLearnGroup(boolean isCorrect) {
        if (isCorrect) {
            learnGroup = Math.min(learnGroup + 1, MAX_LEARN_GROUP);
        }
        else {
            learnGroup = 1;
        }
        dueDate = LearnGroupUtil.calculateDueDate(learnGroup);
    }

    // crazy parcel shit
    private Word (Parcel in) {
        this.id = in.readInt();
        this.original = in.readString();
        this.translation = in.readString();
        this.learnGroup = in.readInt();
        this.dueDate = DateUtil.formatDate(in.readInt());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeInt(id);
        out.writeString(original);
        out.writeString(translation);
        out.writeInt(learnGroup);
        out.writeInt(DateUtil.formatDate(dueDate));
    }

    public static final Parcelable.Creator<Word> CREATOR = new Parcelable.Creator<Word>() {
        public Word createFromParcel (Parcel in) {
            return new Word(in);
        }
        public Word[] newArray(int size) {
            return new Word[size];
        }
    };

    // getters and setters
    public String getOriginal() {
        return original;
    }

    public String getTranslation() {
        return translation;
    }

    public int getLearnGroup() {
        return learnGroup;
    }

    public Calendar getDueDate() {
        return dueDate;
    }
}