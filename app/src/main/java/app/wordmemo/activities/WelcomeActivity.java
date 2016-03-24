package app.wordmemo.activities;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import app.wordmemo.R;
import app.wordmemo.databinding.ActivityWelcomeBinding;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        ActivityWelcomeBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_welcome);
        String testString = "Open Practice";
        binding.setTest(testString);
    }

    public void startPractice(View view) {
        Intent intent = new Intent(this, PracticeActivity.class);
        startActivity(intent);
    }
}
