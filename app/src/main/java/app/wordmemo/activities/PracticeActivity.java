package app.wordmemo.activities;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Calendar;
import java.util.List;
import java.util.Random;

import app.wordmemo.R;
import app.wordmemo.fragments.PracticeInputFragment;
import app.wordmemo.fragments.PracticeResultFragment;
import app.wordmemo.managers.WordDAO;
import app.wordmemo.models.Word;

public class PracticeActivity extends AppCompatActivity
        implements PracticeInputFragment.OnSubmitUserTranslationListener,
        PracticeResultFragment.OnSubmit {

    private List<Word> dueWords;
    private Word currentWord;

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

        currentWord = dueWords.get(new Random().nextInt(dueWords.size()));

        PracticeInputFragment practiceInputFragment = PracticeInputFragment.getInstance(currentWord);

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.practice_container, practiceInputFragment);
        fragmentTransaction.commit();
    }

    public void fillDataBase () {
        Calendar past = Calendar.getInstance();
        past.add(Calendar.DATE, -3);

        WordDAO wd = WordDAO.getInstance(this);
        wd.open();

        wd.insertWord(new Word(-1, "gestern", "igår", 1, past));
        wd.insertWord(new Word(-1, "Dienstag", "tisdag", 1, past));
        wd.insertWord(new Word(-1, "Hallo", "Hej", 1, past));
        wd.insertWord(new Word(-1, "Huhu", "Tja", 1, past));
        wd.insertWord(new Word(-1, "Alina", "Alex", 1, past));
        wd.insertWord(new Word(-1, "Wow, es funktioniert", "...Oder auch nicht", 1, past));
        wd.insertWord(new Word(-1, "Naja", "Egal", 1, past));

        wd.close();
    }

    private void showNextDueWord () {
        dueWords.remove(currentWord);
        if (dueWords.size() == 0) {
            // TODO: Insert Fragment that shows "no more words today"
            return;
        }
        currentWord = dueWords.get(new Random().nextInt(dueWords.size()));

        PracticeInputFragment practiceInputFragment = PracticeInputFragment.getInstance(currentWord);

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.practice_container, practiceInputFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onSubmitUserTranslation(boolean isTranslationCorrect) {
        PracticeResultFragment resultFragment = PracticeResultFragment.getInstance(currentWord, isTranslationCorrect);

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.practice_container, resultFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onSubmit () {
        showNextDueWord();
    }
}
