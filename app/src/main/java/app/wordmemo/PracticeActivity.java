package app.wordmemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ViewFlipper;

import java.util.List;
import java.util.Random;

public class PracticeActivity extends AppCompatActivity {

    List<Word> dueWords;
    TextView originalDueWordView;
    Word currentDueWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);

        WordController wordController = new WordController();
        this.dueWords = wordController.getDueWords();
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
