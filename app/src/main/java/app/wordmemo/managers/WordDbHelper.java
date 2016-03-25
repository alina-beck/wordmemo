package app.wordmemo.managers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class WordDbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "words.db";
    public static final int DATABASE_VERSION = 1;

    public static final String TABLE_WORDS = "words";

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_ORIGINAL = "original";
    public static final String COLUMN_TRANSLATION = "translation";
    public static final String COLUMN_DUEDATE = "due date";

    //database creation SQL syntax
    private static final String CREATE_DATABASE = "create table " + TABLE_WORDS +
            "(" + COLUMN_ID + " integer primary key, "
            + COLUMN_ORIGINAL + " text not null, "
            + COLUMN_TRANSLATION + " text not null, "
            + COLUMN_DUEDATE + " integer not null);";

    public WordDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(CREATE_DATABASE);
    }

    @Override
    public void onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
