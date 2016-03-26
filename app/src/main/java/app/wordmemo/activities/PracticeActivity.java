package app.wordmemo.activities;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;
import java.util.List;
import java.util.Random;

import app.wordmemo.R;
import app.wordmemo.fragments.PracticeInputFragment;
import app.wordmemo.managers.WordDAO;
import app.wordmemo.models.Word;

public class PracticeActivity extends AppCompatActivity {

    private List<Word> dueWords;
    private Word currentDueWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);

        // TODO: replace when app is distributed
        fillDataBase();

        WordDAO wd = WordDAO.getInstance(this);
        wd.open();
        dueWords = wd.fetchDueWords();
        wd.close();

        if (dueWords.size() == 0) {
            // TODO: Insert Fragment that shows "no more words today"
            return;
        }

        currentDueWord = dueWords.get(new Random().nextInt(dueWords.size()));

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        PracticeInputFragment practiceInputFragment = PracticeInputFragment.newInstance(currentDueWord);
        fragmentTransaction.add(R.id.practice_container, practiceInputFragment);
        fragmentTransaction.commit();
    }

    public void validateUserTranslation () {
        EditText editText = (EditText) findViewById(R.id.userTranslation);
        String userTranslation = editText.getText().toString();
        String validTranslation = currentDueWord.getTranslation();

        boolean isTranslationRight = userTranslation.equalsIgnoreCase(validTranslation);

        dueWords.remove(currentDueWord);
    }

    public void fillDataBase () {
        Calendar past = Calendar.getInstance();
        past.add(Calendar.DATE, -3);

        WordDAO wd = WordDAO.getInstance(this);
        wd.open();

        wd.insertWord(new Word(-1, "gestern", "igår", past));
        wd.insertWord(new Word(-1, "Dienstag", "tisdag", past));
        wd.insertWord(new Word(-1, "Hallo", "Hej", past));

        wd.close();
    }
}
