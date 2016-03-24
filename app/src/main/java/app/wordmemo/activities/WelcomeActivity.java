package app.wordmemo.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import app.wordmemo.R;
import app.wordmemo.fragments.MenuFragment;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        if (findViewById(R.id.menu_fragment_container) != null) {
            if (savedInstanceState != null) {
                return;
            }

            MenuFragment menuFragment = new MenuFragment();

            getSupportFragmentManager().beginTransaction().add(R.id.menu_fragment_container, menuFragment).commit();
        }

    }

    public void startPractice(View view) {
        Intent intent = new Intent(this, PracticeActivity.class);
        startActivity(intent);
    }
}
