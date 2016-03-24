package app.wordmemo.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import app.wordmemo.R;
import app.wordmemo.fragments.AddWordFragment;

public class AddWordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_word);

        if (findViewById(R.id.fragment_container) != null) {
            if (savedInstanceState != null) {
                return;
            }

            AddWordFragment addWordFragment = new AddWordFragment();

            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, addWordFragment).commit();
        }
    }
}
