package app.wordmemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ViewFlipper;

public class PracticeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice);
    }

    public void changeView (View view) {
        ViewFlipper flip = (ViewFlipper) findViewById(R.id.practiceViewFlipper);
        flip.showNext();
    }
}
