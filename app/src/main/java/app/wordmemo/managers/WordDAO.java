package app.wordmemo.managers;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import app.wordmemo.models.Word;
import app.wordmemo.utils.DateUtil;

public class WordDAO {

    private static WordDAO sInstance;

    private SQLiteDatabase wordDatabase;
    private WordDbHelper wordDbHelper;

    private WordDAO(Context context) {
        wordDbHelper = new WordDbHelper(context);
    }

    public static synchronized WordDAO getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new WordDAO(context);
        }
        return sInstance;
    }

    public void open() {
        wordDatabase = wordDbHelper.getWritableDatabase();
    }

    public void close() {
        wordDbHelper.close();
    }

    public boolean insertWord (Word word) {
        ContentValues values = new ContentValues();
        values.put(WordDbHelper.COLUMN_ID, word.getId());
        values.put(WordDbHelper.COLUMN_ORIGINAL, word.getOriginal());
        values.put(WordDbHelper.COLUMN_TRANSLATION, word.getTranslation());
        values.put(WordDbHelper.COLUMN_DUEDATE, DateUtil.formatDate(word.getDueDate()));

        long result = wordDatabase.insert(WordDbHelper.TABLE_WORDS, null, values);

        return result != -1;

    }

}
