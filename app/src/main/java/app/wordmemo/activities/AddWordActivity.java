package app.wordmemo.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import app.wordmemo.R;
import app.wordmemo.fragments.AddWordFragment;

public class AddWordActivity extends AppCompatActivity implements AddWordFragment.OnSaveWord {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_word);

        AddWordFragment addWordFragment = new AddWordFragment(); // no instance because no args are passed on
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, addWordFragment).commit();
    }

    @Override
    public void onSaveWord() {
        AddWordFragment newAddWordFragment = new AddWordFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, newAddWordFragment)
                .addToBackStack(null).commit();

    }
}
