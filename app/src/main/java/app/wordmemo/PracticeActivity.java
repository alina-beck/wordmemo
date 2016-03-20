package app.wordmemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.ViewFlipper;

import java.util.List;
import java.util.Random;

public class PracticeActivity extends AppCompatActivity {

    List<Word> dueWords;
    TextView originalDueWordView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);
        WordController wordController = new WordController();
        this.dueWords = wordController.getDueWords();
        this.originalDueWordView = (TextView) findViewById(R.id.originalDueWord);
        displayOriginalDueWord();
    }

    public void displayOriginalDueWord () {
        Word randomWord = dueWords.get(new Random().nextInt(dueWords.size()));
        originalDueWordView.setText(randomWord.getOriginal());
    }

    public void changeView (View view) {
        ViewFlipper flip = (ViewFlipper) findViewById(R.id.practiceViewFlipper);
        flip.showNext();
    }
}
