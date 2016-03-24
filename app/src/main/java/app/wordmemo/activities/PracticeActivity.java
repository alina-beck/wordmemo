package app.wordmemo.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ViewFlipper;

import java.util.List;
import java.util.Random;

import app.wordmemo.MockData;
import app.wordmemo.R;
import app.wordmemo.managers.WordDAO;
import app.wordmemo.models.Word;

public class PracticeActivity extends AppCompatActivity {

    List<Word> dueWords;
    TextView originalDueWordView;
    Word currentDueWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);

        MockData mockData = new MockData();
        this.dueWords = mockData.getData();
        this.originalDueWordView = (TextView) findViewById(R.id.originalDueWord);
        setCurrentDueWord();
    }

    public void setCurrentDueWord () {
        this.currentDueWord = dueWords.get(new Random().nextInt(dueWords.size()));
        originalDueWordView.setText(currentDueWord.getOriginal());
    }

    public void validateUserTranslation (View view) {
        EditText editText = (EditText) findViewById(R.id.userTranslation);
        String userTranslation = editText.getText().toString();
        String validTranslation = currentDueWord.getTranslation();

        boolean isTranslationRight = userTranslation.equalsIgnoreCase(validTranslation);

        dueWords.remove(currentDueWord);
        changeView(isTranslationRight);
    }

    public void changeView (boolean isTranslationRight) {
        ViewFlipper flip = (ViewFlipper) findViewById(R.id.practiceViewFlipper);

        if (isTranslationRight) {
            flip.setDisplayedChild(flip.indexOfChild(findViewById(R.id.practiceRight)));
        }
        else {
            flip.setDisplayedChild(flip.indexOfChild(findViewById(R.id.practiceWrong)));
        }
    }
}
