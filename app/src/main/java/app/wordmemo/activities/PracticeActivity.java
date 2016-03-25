package app.wordmemo.activities;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

import app.wordmemo.R;
import app.wordmemo.fragments.PracticeInputFragment;
import app.wordmemo.models.Word;

public class PracticeActivity extends AppCompatActivity {

    private List<Word> dueWords;
    private TextView originalDueWordView;
    private Word currentDueWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);

        // TODO: replace when database is up
        currentDueWord = new Word("Haus", "hus");

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        PracticeInputFragment practiceInputFragment = PracticeInputFragment.newInstance(currentDueWord);
        fragmentTransaction.add(R.id.practice_container, practiceInputFragment);
        fragmentTransaction.commit();
    }

    public void setCurrentDueWord () {
        this.currentDueWord = dueWords.get(new Random().nextInt(dueWords.size()));
        originalDueWordView.setText(currentDueWord.getOriginal());
    }

    public void validateUserTranslation () {
        EditText editText = (EditText) findViewById(R.id.userTranslation);
        String userTranslation = editText.getText().toString();
        String validTranslation = currentDueWord.getTranslation();

        boolean isTranslationRight = userTranslation.equalsIgnoreCase(validTranslation);

        dueWords.remove(currentDueWord);
    }
}
