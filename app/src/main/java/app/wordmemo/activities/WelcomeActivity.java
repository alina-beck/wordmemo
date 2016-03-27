package app.wordmemo.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.Calendar;

import app.wordmemo.R;
import app.wordmemo.fragments.MenuFragment;
import app.wordmemo.managers.WordDAO;
import app.wordmemo.models.Word;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        // TODO: replace when app is distributed
        fillDataBase();
        
        getSupportFragmentManager().beginTransaction().add(R.id.container_welcome, new MenuFragment()).commit();

    }

    public void fillDataBase() {
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

    public void startPractice(View view) {
        Intent intent = new Intent(this, PracticeActivity.class);
        startActivity(intent);
    }

    public void startAddWord(View view) {
        Intent intent = new Intent(this, AddWordActivity.class);
        startActivity(intent);
    }
}
